package com.juandgaines.todoapp.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.juandgaines.todoapp.data.DataSourceFactory
import com.juandgaines.todoapp.presentation.screens.detail.TaskScreenRoot
import com.juandgaines.todoapp.presentation.screens.detail.TaskViewModel
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenRoot
import com.juandgaines.todoapp.presentation.screens.home.HomeScreenViewModel
import com.juandgaines.todoapp.presentation.screens.home.HomeViewModelFactory
import com.juandgaines.todoapp.presentation.screens.home.TaskViewModelFactory
import kotlinx.serialization.Serializable

@Composable
fun NavigationRoot (
    navController: NavHostController
){

    val context = LocalContext.current
    val backStackEntry by  navController.currentBackStackEntryAsState()


    Box (
        modifier = Modifier.fillMaxSize()
    )
    {
        NavHost(
            navController = navController,
            startDestination = HomeScreenDes
        ){
            composable<HomeScreenDes>{

                    val homeScreenViewModel: HomeScreenViewModel = viewModel(
                        factory = HomeViewModelFactory(
                            dataSource = DataSourceFactory.createDataSource(context)
                        )
                    )
                    HomeScreenRoot(
                        viewModel = homeScreenViewModel,
                        navigateToTaskScreen = { taskId ->
                            navController.navigate(TaskScreenDes(
                                taskId = taskId
                            )
                            )
                        }
                    )


            }

            composable<TaskScreenDes> {
                val taskViewModel: TaskViewModel = viewModel(
                    factory = TaskViewModelFactory(
                        dataSource = DataSourceFactory.createDataSource(context)
                    )
                )
                TaskScreenRoot(
                    viewModel = taskViewModel,
                    navigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

@Serializable
object HomeScreenDes

@Serializable
data class TaskScreenDes(val taskId: String? = null)