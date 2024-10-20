package com.juandgaines.todoapp

import android.app.Application
import com.juandgaines.todoapp.data.DataSourceFactory
import com.juandgaines.todoapp.domain.TaskLocalDataSource

class TodoApplication:Application() {

    val dataSource :TaskLocalDataSource
        get() = DataSourceFactory.createDataSource(this)

}