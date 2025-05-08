package com.juandgaines.todoapp.presentation.screens.detail

interface TaskEvent {
    data object TaskCreated : TaskEvent
    data object TaskEdited : TaskEvent
}