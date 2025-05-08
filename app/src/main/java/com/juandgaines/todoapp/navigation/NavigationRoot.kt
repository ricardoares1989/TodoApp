package com.juandgaines.todoapp.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.juandgaines.todoapp.presentation.screens.detail.TaskScreenRoot
import com.juandgaines.todoapp.presentation.screens.detail.TaskViewModel
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenRoot
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenViewModel
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot(
    navController: NavHostController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        NavHost(
            navController = navController,
            startDestination = HomeScreenDestination
        ) {
            composable<HomeScreenDestination> {
                val viewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreenRoot(
                    viewModel = viewModel,
                    navigateToTaskScreeen = {
                        navController.navigate(TaskScreenDestination(it))
                    }
                )
            }
            composable<TaskScreenDestination> {
                val viewModel = hiltViewModel<TaskViewModel>()
                TaskScreenRoot(
                    viewModel = viewModel,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Serializable
object HomeScreenDestination

@Serializable
data class TaskScreenDestination(
    val taskId: String? = null
)