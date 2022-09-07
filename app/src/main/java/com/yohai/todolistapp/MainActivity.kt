package com.yohai.todolistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.yohai.todolistapp.datasource.TodoListDB
import com.yohai.todolistapp.models.Task
import com.yohai.todolistapp.ui.theme.TodoListAppTheme
import dagger.android.AndroidInjection
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var db: TodoListDB

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            db.taskDao().insert(
                Task(title = "1"),
                Task(title = "2"),
                Task(title = "3"),
                Task(title = "4"),
                Task(title = "5"),
            )
        }

        setContent {
            TodoListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskList(db.taskDao()::getAll) {
                        lifecycleScope.launch(Dispatchers.IO) {
                            db.taskDao().insert(it)
                        }
                    }
                }
            }
        }
    }
}