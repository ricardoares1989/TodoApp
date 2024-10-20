package com.juandgaines.todoapp.presentation.screens.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.juandgaines.todoapp.domain.TaskLocalDataSource
import com.juandgaines.todoapp.presentation.screens.detail.TaskViewModel

class TaskViewModelFactory(
    private val dataSource: TaskLocalDataSource) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            val savedStateHandle = extras.createSavedStateHandle()
            return TaskViewModel(savedStateHandle,dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class HomeViewModelFactory(
    private val dataSource: TaskLocalDataSource) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            val savedStateHandle = extras.createSavedStateHandle()
            return HomeScreenViewModel(savedStateHandle,dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}