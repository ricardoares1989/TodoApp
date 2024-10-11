package com.juandgaines.todoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juandgaines.todoapp.data.local.task.TaskDao
import com.juandgaines.todoapp.data.local.task.TaskEntity

@Database(
    entities = [
        TaskEntity::class
    ], version = 1
)
abstract class TodoAppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}