package com.juandgaines.todoapp.presentation.screens.detail

sealed interface ActionTask {
    data object SaveTask : ActionTask
    data class ChangeCategory(val category: Category) : ActionTask
    data object Back : ActionTask
    data class ChangeTaskDone(val isTaskDone: Boolean) : ActionTask
}