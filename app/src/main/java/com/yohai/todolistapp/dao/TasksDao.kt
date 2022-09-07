package com.yohai.todolistapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yohai.todolistapp.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Insert
    fun insert(tasks: Task)

    @Insert
    fun insert(vararg tasks: Task)

    @Query("SELECT * FROM Task")
    fun getAll(): Flow<List<Task>>
}