package com.taetae98.widget.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Memo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val memo: String = ""
)