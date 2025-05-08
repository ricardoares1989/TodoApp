package com.juandgaines.todoapp.domain

import com.juandgaines.todoapp.presentation.screens.detail.Category
import java.time.LocalDateTime

data class Task(
    val id: String,
    val title: String,
    val description: String?,
    val isCompleted: Boolean = false,
    val category: Category? = null,
    val date: LocalDateTime = LocalDateTime.now()
)
