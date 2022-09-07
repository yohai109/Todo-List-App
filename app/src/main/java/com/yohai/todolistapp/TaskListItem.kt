package com.yohai.todolistapp

import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.yohai.todolistapp.models.Task

@Composable
fun TaskListItem(item: Task, onCompleteChange: (Task) -> Unit) {
    Text(
        text = item.title,
        fontSize = 16.sp
    )

    Text(text = item.id, fontSize = 12.sp)

    Checkbox(
        checked = item.isCompleted,
        onCheckedChange = { onCompleteChange(item.copy(isCompleted = it)) }
    )
}