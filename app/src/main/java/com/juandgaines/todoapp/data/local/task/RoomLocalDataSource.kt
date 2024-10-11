package com.juandgaines.todoapp.data.local.task

import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.domain.TaskDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val taskDao: TaskDao
): TaskDataSource {
    override suspend fun insertTask(task: Task): Result<Unit> {
        return try {
            taskDao.saveTask(task.toTaskEntity())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun updateTask(task: Task): Result<Unit> {
        return try {
            taskDao.saveTask(task.toTaskEntity())
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun deleteTask(taskId: String): Result<Unit> {
        return try {
            taskDao.deleteTaskById(taskId)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getTaskById(taskId: String): Result<Task?> {
        return try {
            val task = taskDao.getTaskById(taskId)?.toTask()
            Result.success(task)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks().map { taskEntities ->
            taskEntities.map { it.toTask() }
        }
    }
}