package com.yohai.todolistapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.yohai.todolistapp.models.Task
import kotlinx.coroutines.flow.Flow

@Composable
fun TaskList(
    getAll: () -> Flow<List<Task>>, onCompleteChange: (Task) -> Unit
) {
    val tasks: List<Task> by getAll().collectAsState(emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = tasks,
            itemContent = {
                TaskListItem(item = it, onCompleteChange = onCompleteChange)
            },
        )
    }
}