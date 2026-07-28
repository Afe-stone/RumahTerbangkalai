package com.example.rumahterbangkalai.view

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rumahterbangkalai.R
import com.example.rumahterbangkalai.util.SaveManager

class MenuActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var saveManager: SaveManager
    private lateinit var btnContinue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        mediaPlayer = MediaPlayer.create(this, R.raw.mainmenu)
        mediaPlayer?.isLooping = true // Agar musik mengulang (looping) terus
        mediaPlayer?.start()

        saveManager = SaveManager(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnContinue = findViewById(R.id.btnContinue)
        val btnNewGame: Button = findViewById(R.id.btnNewGame)
        val btnLoad: Button = findViewById(R.id.btnLoad)
        val btnExit: Button = findViewById(R.id.btnExit)

        btnNewGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }
        btnContinue.setOnClickListener {
            loadSavedGame()
        }

        btnLoad.setOnClickListener {
            loadSavedGame()
        }
    }

    private fun loadSavedGame() {
        if (saveManager.hasSaveData()) {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("LOAD_NODE", saveManager.getSavedNode())
            intent.putExtra("LOAD_INDEX", saveManager.getSavedLineIndex())
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        } else {
            Toast.makeText(this, "No save data found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer?.isPlaying == true) {
            mediaPlayer?.pause()
        }
    }

    override fun onResume() {
        super.onResume()
        if (mediaPlayer != null && !mediaPlayer!!.isPlaying) {
            mediaPlayer?.start()
        }
        // Update Continue button status
        btnContinue.isEnabled = saveManager.hasSaveData()
        btnContinue.alpha = if (saveManager.hasSaveData()) 1.0f else 0.5f
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
