package com.juandgaines.todoapp.domain

import java.time.LocalDate

data class Task(
    val id: String,
    val title:String,
    val description:String?,
    val isCompleted:Boolean = false,
    val category: Category? = null,
    val date: LocalDate = LocalDate.now()
)
