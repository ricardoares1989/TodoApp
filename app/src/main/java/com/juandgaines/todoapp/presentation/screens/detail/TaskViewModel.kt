package com.juandgaines.todoapp.presentation.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juandgaines.todoapp.data.FakeTaskLocalDataSource
import com.juandgaines.todoapp.domain.Task
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.UUID

class TaskViewModel : ViewModel() {

    private val fakeTaskLocalDataSource = FakeTaskLocalDataSource

    var state by mutableStateOf(TaskScreenState())
        private set

    private var eventChannel = Channel<TaskEvent>()
    val event = eventChannel.receiveAsFlow()

    fun onAction(action: ActionTask) {
        viewModelScope.launch {
            when (action) {
                is ActionTask.ChangeTaskName -> {
                    state = state.copy(taskName = action.taskName)
                }
                is ActionTask.ChangeTaskDescription -> {
                    state = state.copy(taskDescription = action.taskDescription)
                }
                is ActionTask.ChangeTaskCategory -> {
                    state = state.copy(category = action.category)
                }
                is ActionTask.ChangeTaskDone -> {
                    state = state.copy(isTaskDone = action.isTaskDone)
                }
                is ActionTask.SaveTask -> {
                    val task= Task(
                        id = UUID.randomUUID().toString(),
                        title = state.taskName,
                        description = state.taskDescription,
                        isCompleted = state.isTaskDone,
                        category = state.category
                    )
                    fakeTaskLocalDataSource.addTask(
                        task = task
                    )

                    eventChannel.send(TaskEvent.TaskCreated)
                }
                else -> Unit
            }
        }
    }
}