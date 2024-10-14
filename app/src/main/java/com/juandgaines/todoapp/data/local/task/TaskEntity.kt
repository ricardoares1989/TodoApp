package com.juandgaines.todoapp.data.local.task

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity (
    @PrimaryKey
    val id: String,
    val title: String,
    val description: String?,
    val category:Int?,
    val isCompleted: Boolean
)