package com.juandgaines.todoapp.domain

data class Task(
    val id: String,
    val title: String,
    val description: String?,
    val category: Category?,
    val isCompleted: Boolean
)