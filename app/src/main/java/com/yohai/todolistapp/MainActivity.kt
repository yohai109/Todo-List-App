package com.yohai.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.lifecycleScope
import com.yohai.todolistapp.bl.MainViewModel
import com.yohai.todolistapp.bl.ViewModelFactory
import com.yohai.todolistapp.models.Task
import com.yohai.todolistapp.ui.theme.TodoListAppTheme
import dagger.android.AndroidInjection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: MainViewModel by viewModels { factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            if (viewModel.size() == 0) {
                viewModel.insertTasks(
                    Task(title = "1", order = 1),
                    Task(title = "2", order = 2),
                    Task(title = "3", order = 3),
                    Task(title = "4", order = 4),
                    Task(title = "5", order = 5),
                )
            }
        }

        setContent {
            TodoListAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,
                    topBar = {
                        TopAppBar(
                            title = {Text(text = "Yohai")}
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                lifecycleScope.launch(Dispatchers.IO) {
                                    viewModel.insertTasks(Task(title = "click", order = viewModel.size() + 1))
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
                    TaskList(viewModel::getAllTasksFlow) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            viewModel.insertTasks(it)
                        }
                    }
                }

            }
        }
    }
}