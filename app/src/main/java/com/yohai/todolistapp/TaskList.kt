package com.yohai.todolistapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.yohai.todolistapp.models.Task

@Composable
fun TaskList() {
    val tasks = remember {
        listOf(
            Task("1"),
            Task("2"),
            Task("3")
        )
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tasks,
            itemContent = {
                TaskListItem(item = it)
            }
        )
    }
}