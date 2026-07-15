package com.example.rumahterbengkalai // Sesuaikan dengan package name proyek Anda

data class Choice(
    val text: String,
    val goto: String
)

data class StoryNode(
    val label: String,
    val depth: Int,
    val lines: List<String>,
    val choices: List<Choice> = emptyList(),
    val isEnding: Boolean = false,
    val backgroundColor: String = "#0A0908"
)