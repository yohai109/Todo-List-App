package com.yohai.todolistapp

import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.yohai.todolistapp.bl.MainViewModel
import com.yohai.todolistapp.models.Task

@Composable
fun TaskList(
    onCompleteChange: (Task) -> Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    val tasks: List<Task> by viewModel.getAllTasksFlow().collectAsState(emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(
            items = tasks,
            itemContent = {
                TaskListItem(item = it, onCompleteChange = onCompleteChange)
            },
        )
    }
}