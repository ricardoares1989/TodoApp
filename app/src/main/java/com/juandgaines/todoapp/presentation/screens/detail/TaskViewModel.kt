package com.juandgaines.todoapp.presentation.screens.detail

import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.domain.TaskLocalDataSource
import com.juandgaines.todoapp.navigation.TaskScreenDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val taskLocalDataSource: TaskLocalDataSource
) : ViewModel() {

    val taskData = savedStateHandle.toRoute<TaskScreenDestination>()

    var state by mutableStateOf(TaskScreenState())
        private set

    val eventChannel = Channel<TaskEvent>()
    val events = eventChannel.receiveAsFlow()
    private var editTask: Task? = null

    init {
        taskData.taskId?.let { taskId ->
            viewModelScope.launch {
                val task = taskLocalDataSource.getTaskById(taskId)
                editTask = task
                state = state.copy(
                    taskName = TextFieldState(task?.title ?: ""),
                    taskDescription = TextFieldState(task?.description ?: ""),
                    category = task?.category ?: Category.OTHER,
                    isTaskDone = task?.isCompleted ?: false,
                )

            }
        }
    }

    fun onAction(action: ActionTask) {
        viewModelScope.launch {
            when (action) {
                is ActionTask.ChangeCategory -> {
                    state = state.copy(category = action.category)
                }

                is ActionTask.ChangeTaskDone -> {
                    state = state.copy(isTaskDone = action.isTaskDone)
                }

                ActionTask.SaveTask -> {
                    editTask?.let {
                        taskLocalDataSource.updateTask(
                            it.copy(
                                id = it.id,
                                title = state.taskName.text.toString(),
                                description = state.taskDescription.text.toString(),
                                category = state.category,
                                isCompleted = state.isTaskDone
                            )
                        )
                        eventChannel.send(TaskEvent.TaskEdited)
                    } ?: run {
                        val task = Task(
                            id = UUID.randomUUID().toString(),
                            title = state.taskName.text.toString(),
                            description = state.taskDescription.text.toString(),
                            category = state.category,
                            isCompleted = state.isTaskDone
                        )
                        taskLocalDataSource.addTask(task)
                        eventChannel.send(TaskEvent.TaskCreated)
                    }

                }

                else -> Unit
            }
        }

    }

}