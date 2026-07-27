package com.example.rumahterbangkalai.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rumahterbangkalai.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnContinue: Button = findViewById(R.id.btnContinue)
        val btnNewGame: Button = findViewById(R.id.btnNewGame)
        val btnLoad: Button = findViewById(R.id.btnLoad)
        val btnExit: Button = findViewById(R.id.btnExit)


//        btnContinue.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java
//        }
        btnNewGame.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        btnExit.setOnClickListener {
            finishAffinity()
        }
        btnContinue.setOnClickListener {
            Toast.makeText(this, "males mikir", Toast.LENGTH_SHORT).show()
        }

        btnLoad.setOnClickListener {
            Toast.makeText(this, "besok ajah", Toast.LENGTH_SHORT).show()
        }
        btnContinue.isEnabled = false
    }

}