package com.yohai.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.yohai.todolistapp.bl.MainViewModel
import com.yohai.todolistapp.models.Task
import com.yohai.todolistapp.ui.theme.TodoListAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListAppTheme {
                val viewModel: MainViewModel by viewModels()
                lifecycleScope.launch(Dispatchers.IO) {
                    if (viewModel.size() == 0) {
                        viewModel.insertTasks(
                            Task(title = "1", body = "this is the body", order = 1),
                            Task(title = "2", body = "this is the body", order = 2),
                            Task(title = "3", body = "this is the body", order = 3),
                            Task(title = "4", body = "this is the body", order = 4),
                            Task(title = "5", body = "this is the body", order = 5),
                        )
                    }
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Yohai") }
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                lifecycleScope.launch(Dispatchers.IO) {
                                    viewModel.insertTasks(
                                        Task(
                                            title = "click",
                                            body = "this is the body",
                                            order = viewModel.size() + 1
                                        )
                                    )
                                }
                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_plus_black),
                                contentDescription = null,
                            )
                        }
                    }
                ) {
                    TaskList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(it)
                    ) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            viewModel.insertTasks(it)
                        }
                    }
                }

            }
        }
    }
}