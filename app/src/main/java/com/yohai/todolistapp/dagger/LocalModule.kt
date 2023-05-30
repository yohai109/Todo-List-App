package com.yohai.todolistapp.dagger

import android.content.Context
import androidx.room.Room
import com.yohai.todolistapp.datasource.TodoListDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object LocalModule {

    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        TodoListDB::class.java,
        "main-database"
    ).build()

}