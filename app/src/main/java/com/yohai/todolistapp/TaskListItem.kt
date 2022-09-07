package com.yohai.todolistapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.yohai.todolistapp.models.Task

@Composable
fun TaskListItem(item: Task) {
    Text(text = item.title)
}