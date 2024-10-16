package com.juandgaines.todoapp.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.ui.theme.TodoAppTheme

@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    task:Task,
    onClickItem:(String) -> Unit,
    onDeleteItem:() -> Unit
) {

}

@Composable
@Preview
fun TaskItemPreview() {
    TodoAppTheme {

    }
}