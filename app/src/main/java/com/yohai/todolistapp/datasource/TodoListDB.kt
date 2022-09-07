package com.yohai.todolistapp.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yohai.todolistapp.dao.TasksDao
import com.yohai.todolistapp.models.Task

@Database(
    entities = [Task::class],
    exportSchema = true,
    version = 1
)
abstract class TodoListDB : RoomDatabase() {
    abstract fun taskDao(): TasksDao
}