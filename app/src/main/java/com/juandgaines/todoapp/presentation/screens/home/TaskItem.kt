package com.juandgaines.todoapp.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition.Center
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.style.TextOverflow.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juandgaines.todoapp.domain.Category.WORK
import com.juandgaines.todoapp.domain.Task
import com.juandgaines.todoapp.ui.theme.TodoAppTheme

@Composable
fun TaskItem(
    modifier: Modifier = Modifier,
    onClickItem:(String) -> Unit,
    onDeleteItem:(String) -> Unit,
    onToggleCompletion:(Task) -> Unit,
    task:Task,
) {
    Row (
        modifier = modifier
            .clickable {
                onClickItem(task.id)
            }
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
            ),
    ){
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = {
                onToggleCompletion(
                    task
                )
            },
        )
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(
                4.dp
            ),
            modifier = Modifier.padding(
                8.dp
            ).weight(
                1f
            )
        ){
            Text(
                text = task.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            task.description?.let {
                Text(
                    text = it,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            task.category?.let {
                Text(
                    text = it.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_NO
)
fun TaskItemPreviewLight() {
    TodoAppTheme {
        TaskItem(
            task = Task(
                id = "1",
                title = "Task 1",
                description = "Description of task 1",
                isCompleted = false,
                category = WORK
            ),
            onClickItem = {},
            onDeleteItem = {},
            onToggleCompletion = {}
        )
    }
}

@Composable
@Preview(
    showBackground = true,
    uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES
)
fun TaskItemPreviewDark() {
    TodoAppTheme {
        TaskItem(
            task = Task(
                id = "1",
                title = "Task 1",
                description = "Description of task 1",
                isCompleted = false,
                category = WORK
            ),
            onClickItem = {},
            onDeleteItem = {},
            onToggleCompletion = {}
        )
    }
}