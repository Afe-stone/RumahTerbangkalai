package com.example.rumahterbangkalai.util

import android.content.Context
import android.content.SharedPreferences

class SaveManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("story_save", Context.MODE_PRIVATE)

    fun saveGame(nodeKey: String, lineIndex: Int) {
        prefs.edit().apply {
            putString("current_node", nodeKey)
            putInt("line_index", lineIndex)
            apply()
        }
    }

    fun savePlayerName(name: String) {
        prefs.edit().putString("player_name", name).apply()
    }

    fun getPlayerName(): String {
        return prefs.getString("player_name", "Kamu") ?: "Kamu"
    }

    fun getSavedNode(): String? {
        return prefs.getString("current_node", null)
    }

    fun getSavedLineIndex(): Int {
        return prefs.getInt("line_index", 0)
    }

    fun hasSaveData(): Boolean {
        return prefs.contains("current_node")
    }

    fun clearSaveData() {
        prefs.edit().clear().apply()
    }
}
