package com.juandgaines.todoapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.presentation.screens.detail.Category
import java.time.ZoneId

@Entity(tableName = "tasks")
class TaskEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val title: String,
    val description: String?,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean = false,
    val category: Category? = null,
    val date: Long
) {
    fun toTask(): Task {
        return Task(
            id = id,
            title = title,
            description = description,
            isCompleted = isCompleted,
            category = category,
            date = java.time.LocalDateTime.ofInstant(
                java.time.Instant.ofEpochMilli(date),
                ZoneId.systemDefault()
            )
        )
    }

    companion object {
        fun fromTask(task: Task): TaskEntity {
            return TaskEntity(
                id = task.id,
                title = task.title,
                description = task.description,
                isCompleted = task.isCompleted,
                category = task.category,
                date = task.date.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
            )
        }
    }
}