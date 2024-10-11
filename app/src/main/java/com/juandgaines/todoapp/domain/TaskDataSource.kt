package com.juandgaines.todoapp.domain

import kotlinx.coroutines.flow.Flow

interface TaskDataSource{
    suspend fun insertTask(task: Task):Result<Unit>
    suspend fun updateTask(task: Task):Result<Unit>
    suspend fun deleteTask(taskId: String):Result<Unit>
    suspend fun getTaskById(taskId: String):Result<Task?>
    fun getAllTasks():Flow<List<Task>>
}