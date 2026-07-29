package com.example.rumahterbangkalai.view

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.toColorInt
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.rumahterbangkalai.MusicService
import com.example.rumahterbangkalai.R
import com.example.rumahterbangkalai.util.SaveManager
import com.example.rumahterbengkalai.StoryNode
import com.example.rumahterbengkalai.storyMap
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : AppCompatActivity() {
    private lateinit var rootLayout: View
    private lateinit var tvChapter: TextView
    private lateinit var tvSpeaker: TextView
    private lateinit var tvLine: TextView
    private lateinit var ivArrow: View
    private lateinit var btnPause: Button
    private lateinit var choicesContainer: LinearLayout
    private lateinit var btnRestart: Button
    private lateinit var dialogueBar: View
    private lateinit var saveManager: SaveManager
    private var playerName: String = "Kamu"

    private var currentNode: StoryNode = storyMap["intro"]!!
    private var currentNodeKey: String = "intro"
    private var currentLineIndex = 0
    private var isTyping = false

    private var lastLineStartTime: Long = 0L
    private var typingJob: Job? = null
    private var currentFullLineText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rootLayout = findViewById(R.id.main)
        btnPause = findViewById(R.id.btnPause)
        tvChapter = findViewById(R.id.tv_chapter)
        tvSpeaker = findViewById(R.id.tv_speaker)
        tvLine = findViewById(R.id.tv_line)
        ivArrow = findViewById(R.id.iv_arrow)
        choicesContainer = findViewById(R.id.choices_container)
        btnRestart = findViewById(R.id.btn_restart)
        dialogueBar = findViewById(R.id.dialogue_bar)
        saveManager = SaveManager(this)
        playerName = saveManager.getPlayerName()

        ViewCompat.setOnApplyWindowInsetsListener(rootLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                showPauseMenu()
            }
        })
        btnPause.setOnClickListener {
            showPauseMenu()
        }

        dialogueBar.setOnClickListener {
            handleDialogueClick()
        }

        btnRestart.setOnClickListener {
            goToNode("intro")
        }

        // Start Music
        startService(Intent(this, MusicService::class.java))

        val loadKey = intent.getStringExtra("LOAD_NODE")
        val loadIndex = intent.getIntExtra("LOAD_INDEX", 0)

        if (loadKey != null) {
            goToNode(loadKey, loadIndex)
        } else {
            goToNode("intro")
        }
    }

    private fun goToNode(key: String, lineIndex: Int = 0) {
        val node = storyMap[key] ?: return
        currentNode = node
        currentNodeKey = key
        currentLineIndex = lineIndex

        choicesContainer.visibility = View.GONE
        choicesContainer.removeAllViews()
        btnRestart.visibility = View.GONE
        ivArrow.visibility = View.INVISIBLE

        val ivBackground = findViewById<ImageView>(R.id.ivBackground)

        if (node.backgroundRes != null) {
            ivBackground.visibility = View.VISIBLE
            ivBackground.setImageResource(node.backgroundRes)

            rootLayout.setBackgroundColor(Color.BLACK)
        } else if (!node.backgroundColor.isNullOrEmpty()) {
            ivBackground.visibility = View.GONE
            rootLayout.setBackgroundColor(node.backgroundColor.toColorInt())
        } else {
            ivBackground.visibility = View.GONE
            rootLayout.setBackgroundColor(Color.BLACK)
        }

        tvChapter.text = node.label.uppercase()

        displayCurrentLine()
    }

    private fun displayCurrentLine() {
        var rawLine = currentNode.lines[currentLineIndex]

        // Dynamic name replacement
        rawLine = rawLine.replace("Kamu:", "$playerName:")
        rawLine = rawLine.replace("(Kamu ", "($playerName ")
        rawLine = rawLine.replace(" Kamu ", " $playerName ")
        rawLine = rawLine.replace(" Kamu.", " $playerName.")
        rawLine = rawLine.replace(" Kamu,", " $playerName,")

        val speaker: String
        val dialogue: String

        if (rawLine.contains(":")) {
            val parts = rawLine.split(":", limit = 2)
            speaker = parts[0].trim()
            // Clean dialogue: remove quotes if they wrap the text
            var text = parts[1].trim()
            if (text.startsWith("\"") && text.endsWith("\"")) {
                text = text.substring(1, text.length - 1)
            }
            dialogue = text
        } else {
            speaker = "" // Narration
            dialogue = rawLine
        }

        currentFullLineText = dialogue
        lastLineStartTime = System.currentTimeMillis()
        typingJob?.cancel()
        typingJob = lifecycleScope.launch {
            isTyping = true
            ivArrow.visibility = View.INVISIBLE
            tvSpeaker.text = speaker
            tvLine.text = ""

            val sb = StringBuilder()
            for (char in dialogue) {
                sb.append(char)
                tvLine.text = sb.toString()
                delay(20.milliseconds)
            }
            finishTyping()
        }
    }

    private fun finishTyping() {
        isTyping = false
        tvLine.text = currentFullLineText

        if (currentLineIndex < currentNode.lines.size - 1) {
            ivArrow.visibility = View.VISIBLE
        } else {
            ivArrow.visibility = View.INVISIBLE
            onNodeLineEnd()
        }
    }

    private fun handleDialogueClick() {
        if (System.currentTimeMillis() - lastLineStartTime < 1) {
            return
        }
        if (isTyping) {
            typingJob?.cancel()
            finishTyping()
        } else {
            if (currentLineIndex < currentNode.lines.size - 1) {
                currentLineIndex++
                displayCurrentLine()
            }
        }
    }

    private fun onNodeLineEnd() {
        if (currentNode.isEnding) {
            btnRestart.visibility = View.VISIBLE
        } else {
            showChoices()
        }
    }

    private fun showChoices() {
        val dimOverlay = findViewById<View>(R.id.vDimOverlay)
        choicesContainer.removeAllViews()
        choicesContainer.visibility = View.VISIBLE
        dimOverlay.visibility = View.VISIBLE
        for (choice in currentNode.choices) {
            val button = Button(this).apply {
                val choiceText = choice.text.replace("Kamu", playerName)
                text = getString(R.string.choice_format, choiceText)
                setTextColor("#D9CFBB".toColorInt())
                val choiceFont = ResourcesCompat.getFont(this@MainActivity, R.font.merriweather)
                typeface = choiceFont
                setBackgroundColor("#1A7A2E26".toColorInt())
                textSize = 14f
                setPadding(32, 24, 32, 24)
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 12, 0, 12)
                layoutParams = params

                setOnClickListener {
                    goToNode(choice.goto)
                }
            }
            choicesContainer.addView(button)
        }
    }

    private fun showPauseMenu() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.pause)

        dialog.window?.let { window ->

            window.setBackgroundDrawableResource(android.R.color.transparent)


            window.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                window.attributes.blurBehindRadius = 67
            }
        }

        dialog.setCancelable(true)

        val btnContinue = dialog.findViewById<Button>(R.id.btnContinue)
        val btnSave = dialog.findViewById<Button>(R.id.btnSave)
        val btnLoad = dialog.findViewById<Button>(R.id.btnLoad)
        val btnMainMenu = dialog.findViewById<Button>(R.id.btnMainMenu)

        btnContinue.setOnClickListener { dialog.dismiss() }

        btnSave.setOnClickListener {
            saveManager.saveGame(currentNodeKey, currentLineIndex)
            Toast.makeText(this@MainActivity, "Game Saved", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        btnLoad.setOnClickListener {
            if (saveManager.hasSaveData()) {
                val nodeKey = saveManager.getSavedNode()!!
                val lineIdx = saveManager.getSavedLineIndex()
                goToNode(nodeKey, lineIdx)
                Toast.makeText(this@MainActivity, "Game Loaded", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "No save data found", Toast.LENGTH_SHORT).show()
            }
            dialog.dismiss()
        }

        btnMainMenu.setOnClickListener {
            dialog.dismiss()
            val intent = Intent(this@MainActivity, MenuActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }

        dialog.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, MusicService::class.java))
    }
}
