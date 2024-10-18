package com.juandgaines.todoapp.presentation.screens.detail

import com.juandgaines.todoapp.domain.Category

data class TaskScreenState(
    val taskName: String = "",
    val taskDescription: String? = "",
    val isTaskDone: Boolean = false,
    val category: Category? = null
){
    val canSaveTask: Boolean
        get() = taskName.isNotBlank() && taskName.isNotEmpty()
}