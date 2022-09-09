package com.yohai.todolistapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yohai.todolistapp.models.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TasksDao {
    @Insert(onConflict = REPLACE)
    fun insert(vararg tasks: Task)

    @Query("SELECT * FROM Task ORDER BY `order`")
    fun getAll(): Flow<List<Task>>

    @Query("SELECT COUNT(*) FROM Task")
    fun size(): Int
}