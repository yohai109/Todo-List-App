package com.yohai.todolistapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoListApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

}