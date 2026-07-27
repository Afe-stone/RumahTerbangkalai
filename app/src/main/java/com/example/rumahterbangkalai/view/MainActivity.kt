package com.example.rumahterbangkalai.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
import kotlin.text.iterator

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

        startService(Intent(this, MusicService::class.java))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rootLayout = findViewById(R.id.main)
        tvChapter = findViewById(R.id.tv_chapter)
        tvSpeaker = findViewById(R.id.tv_speaker)
        tvLine = findViewById(R.id.tv_line)
        ivArrow = findViewById(R.id.iv_arrow)
        choicesContainer = findViewById(R.id.choices_container)
        btnRestart = findViewById(R.id.btn_restart)
        dialogueBar = findViewById(R.id.dialogue_bar)

        dialogueBar.setOnClickListener {
            handleDialogueClick()
        }

        btnRestart.setOnClickListener {
            goToNode("intro")
        }

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

        rootLayout.setBackgroundColor(Color.parseColor(node.backgroundColor))
        tvChapter.text = node.label.uppercase()
        tvSpeaker.text = if (node.isEnding) "NARATOR · TAMAT" else "NARATOR"

        displayCurrentLine()
    }

    private fun displayCurrentLine() {
        val line = currentNode.lines[currentLineIndex]
        currentFullLineText = line

        typingJob?.cancel()
        typingJob = lifecycleScope.launch {
            isTyping = true
            ivArrow.visibility = View.INVISIBLE
            tvLine.text = ""

            val sb = StringBuilder()
            for (char in line) {
                sb.append(char)
                tvLine.text = sb.toString()
                delay(2000)
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
                text = "— ${choice.text}"
                setTextColor(Color.parseColor("#D9CFBB"))
                setBackgroundColor(Color.parseColor("#1A7A2E26"))
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

    override fun onDestroy() {
        super.onDestroy()
        // Hentikan musik saat aplikasi ditutup
        stopService(Intent(this, MusicService::class.java))
    }
}