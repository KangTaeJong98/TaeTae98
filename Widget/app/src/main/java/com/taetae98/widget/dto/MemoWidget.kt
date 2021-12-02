package com.taetae98.widget.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MemoWidget(
    @PrimaryKey
    val id: Int
)