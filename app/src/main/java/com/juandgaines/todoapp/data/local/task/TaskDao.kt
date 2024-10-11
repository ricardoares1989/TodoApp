package com.juandgaines.todoapp.data.local.task

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Upsert
    suspend fun saveTask(task: TaskEntity)

    @Query("SELECT * FROM task")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM task WHERE id = :taskId")
    suspend fun getTaskById(taskId: String): TaskEntity?

    @Query("DELETE FROM task WHERE id = :taskId")
    suspend fun deleteTaskById(taskId: String)

    @Query("DELETE FROM task")
    suspend fun deleteAllTasks()

}