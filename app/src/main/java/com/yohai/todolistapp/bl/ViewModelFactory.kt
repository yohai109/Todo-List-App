package com.yohai.todolistapp.bl

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yohai.todolistapp.datasource.TodoListDB
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val db: TodoListDB) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Log.d("yohai", modelClass.name)
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) return MainViewModel(db) as T
        throw IllegalArgumentException()
    }

}