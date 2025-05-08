package com.juandgaines.todoapp.presentation.screens.home

import com.juandgaines.todoapp.domain.Task

data class HomeDataState(
    val date: String = "",
    val summary: String = "",
    val completedTasks: List<Task> = emptyList(),
    val pendingTasks: List<Task> = emptyList()
)