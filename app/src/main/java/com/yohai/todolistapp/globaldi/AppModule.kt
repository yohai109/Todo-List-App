package com.yohai.todolistapp.globaldi

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.yohai.todolistapp.bl.ViewModelFactory
import com.yohai.todolistapp.datasource.TodoListDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun db(context: Context): TodoListDB {
        return Room.databaseBuilder(
            context,
            TodoListDB::class.java, "main-database"
        ).build()
    }
}