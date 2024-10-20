package com.juandgaines.todoapp.data

import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.domain.TaskLocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomTaskLocalDataSource(
    private val taskDao: TaskDao
):TaskLocalDataSource {
    override val tasksFlow: Flow<List<Task>>
        get() = taskDao.getAllTasks().map {
            it.map { taskEntity -> taskEntity.toTask() }
        }

    override suspend fun addTask(task: Task) {
        taskDao.upsertTask(TaskEntity.fromTask(task))
    }

    override suspend fun updateTask(updatedTask: Task) {
        taskDao.upsertTask(TaskEntity.fromTask(updatedTask))
    }

    override suspend fun removeTask(task: Task) {
        taskDao.deleteTaskById(task.id)
    }

    override suspend fun deleteAllTasks() {
        taskDao.deleteAllTasks()
    }

    override suspend fun getTaskById(taskId: String): Task? {
        return taskDao.getTaskById(taskId)?.toTask()
    }

    override suspend fun removeAllTasks() {
        taskDao.deleteAllTasks()
    }
}