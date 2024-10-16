package com.juandgaines.todoapp.domain

data class Task(
    val id: Int,
    val title:String,
    val description:String?,
    val isCompleted:Boolean = false,
    val category: Int? = null
)
