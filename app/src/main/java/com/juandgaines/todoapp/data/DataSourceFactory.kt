package com.juandgaines.todoapp.data

import android.content.Context
import com.juandgaines.todoapp.domain.TaskLocalDataSource

object DataSourceFactory {
    fun createDataSource(context: Context): TaskLocalDataSource {
        val database = TodoDatabase.getDatabase(context)
        return RoomTaskLocalDataSource(database.taskDao())
    }
}