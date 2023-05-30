package com.yohai.todolistapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Task(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val body: String,
    val isCompleted: Boolean = false,
    val order: Int
)
