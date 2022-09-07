package com.yohai.todolistapp

import android.app.Application
import dagger.android.*
import com.yohai.todolistapp.globaldi.DaggerApplicationComponent
import javax.inject.Inject

class TodoListApplication : Application(), HasAndroidInjector {

    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
        super.onCreate()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }
}