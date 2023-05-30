package com.yohai.todolistapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.yohai.todolistapp.bl.MainViewModel
import com.yohai.todolistapp.models.Task
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun TaskList(
    modifier: Modifier,
    onCompleteChange: (Task) -> Unit
) {
    val viewModel = hiltViewModel<MainViewModel>()
    val tasks: List<Task> by viewModel.getAllTasksFlow().collectAsState(emptyList())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = modifier
    ) {
        items(
            items = tasks,
            itemContent = {
                TaskListItem(item = it, onCompleteChange = onCompleteChange)
            },
        )
    }
}