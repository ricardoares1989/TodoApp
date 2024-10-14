package com.juandgaines.todoapp.data.local.task

import com.juandgaines.todoapp.domain.Category
import com.juandgaines.todoapp.domain.Task

fun TaskEntity.toTask(): Task {
    return Task(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        category = Category.fromOrdinal(category)

    )
}

fun Task.toTaskEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        isCompleted = isCompleted,
        category = category?.ordinal
    )
}