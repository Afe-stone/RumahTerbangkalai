package com.example.rumahterbangkalai.view

import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Button
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
    private lateinit var choicesContainer: LinearLayout
    private lateinit var btnRestart: Button
    private lateinit var dialogueBar: View
    private var currentNode: StoryNode = storyMap["intro"]!!
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
        tvChapter = findViewById(R.id.tv_chapter)
        tvSpeaker = findViewById(R.id.tv_speaker)
        tvLine = findViewById(R.id.tv_line)
        ivArrow = findViewById(R.id.iv_arrow)
        choicesContainer = findViewById(R.id.choices_container)
        btnRestart = findViewById(R.id.btn_restart)
        dialogueBar = findViewById(R.id.dialogue_bar)

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

        dialogueBar.setOnClickListener {
            handleDialogueClick()
        }

        btnRestart.setOnClickListener {
            goToNode("intro")
        }

        // Start Music
        startService(Intent(this, MusicService::class.java))

        goToNode("intro")
    }

    private fun goToNode(key: String) {
        val node = storyMap[key] ?: return
        currentNode = node
        currentLineIndex = 0

        choicesContainer.visibility = View.GONE
        choicesContainer.removeAllViews()
        btnRestart.visibility = View.GONE
        ivArrow.visibility = View.INVISIBLE

        rootLayout.setBackgroundColor(node.backgroundColor.toColorInt())
        tvChapter.text = node.label.uppercase()
        tvSpeaker.text = if (node.isEnding) "NARATOR · TAMAT" else "NARATOR"

        displayCurrentLine()
    }

    private fun displayCurrentLine() {
        val line = currentNode.lines[currentLineIndex]
        currentFullLineText = line
        lastLineStartTime = System.currentTimeMillis()
        typingJob?.cancel()
        typingJob = lifecycleScope.launch {
            isTyping = true
            ivArrow.visibility = View.INVISIBLE
            tvLine.text = ""

            val sb = StringBuilder()
            for (char in line) {
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
        if (System.currentTimeMillis() - lastLineStartTime < 1000) {
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
        choicesContainer.removeAllViews()
        choicesContainer.visibility = View.VISIBLE

        for (choice in currentNode.choices) {
            val button = Button(this).apply {
                text = getString(R.string.choice_format, choice.text)
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
            // Hilangkan background bawaan dialog agar drawable XML kita yang mengambil alih
            window.setBackgroundDrawableResource(android.R.color.transparent)

            // Buat window memenuhi layar agar efk gradient-nya meluas ke seluruh layar
            window.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                window.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                window.attributes.blurBehindRadius = 67 // Tingkat keburaman blur (bisa diubah 10-50)
            }
            // Hapus efek dim bawaan Android agar tidak memblokir gradient kita
//            window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        }

        dialog.setCancelable(true)

        val btnContinue = dialog.findViewById<Button>(R.id.btnContinue)
        val btnSave = dialog.findViewById<Button>(R.id.btnSave)
        val btnLoad = dialog.findViewById<Button>(R.id.btnLoad)
        val btnMainMenu = dialog.findViewById<Button>(R.id.btnMainMenu)

        btnContinue.setOnClickListener { dialog.dismiss() }

        btnSave.setOnClickListener {
            Toast.makeText(this@MainActivity, "fitur belum adaa", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        btnLoad.setOnClickListener {
            Toast.makeText(this@MainActivity, "fitur belum adaa", Toast.LENGTH_SHORT).show()
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
