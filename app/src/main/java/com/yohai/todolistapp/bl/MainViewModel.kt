package com.yohai.todolistapp.bl

import androidx.lifecycle.ViewModel
import com.yohai.todolistapp.datasource.TodoListDB
import com.yohai.todolistapp.models.Task

class MainViewModel(
    private val db: TodoListDB,
) : ViewModel() {

    fun getAllTasksFlow() = db.taskDao().getAll()

    suspend fun insertTasks(vararg tasks: Task) = db.taskDao().insert(*tasks)

    suspend fun size() = db.taskDao().size()

}