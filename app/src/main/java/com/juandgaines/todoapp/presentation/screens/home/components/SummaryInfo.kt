package com.juandgaines.todoapp.presentation.screens.home.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.juandgaines.todoapp.R
import kotlin.math.round

@Composable
fun SummaryInfo(
    modifier: Modifier = Modifier,
    date: String = "March 30, 2025",
    taskSummary: String = "5, Incomplete, 5 completed",
    completedTasks: Int,
    totalTasks: Int
) {
    val angleRatio = remember {
        Animatable(0f)
    }
    LaunchedEffect(completedTasks, totalTasks) {
        if (totalTasks != 0) {
            angleRatio.animateTo(
                targetValue = (completedTasks.toFloat() / totalTasks.toFloat()),
                animationSpec = tween(
                    durationMillis = 1000
                )
            )
        } else {
            return@LaunchedEffect
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .weight(1.5f)
        ) {
            Text(
                text = date,
                style = typography.headlineLarge,
                color = colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.summary_info, taskSummary),
                style = typography.titleSmall,
                color = colorScheme.onSurface,
            )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(16.dp)
                .aspectRatio(1f)
                .weight(1f)
        ) {
            val colorBase = colorScheme.inversePrimary
            val colorProgress = colorScheme.primary
            val strokeWidth = 16.dp
            Canvas(
                modifier = Modifier.aspectRatio(1f)
            ) {
                drawArc(
                    color = colorBase,
                    startAngle = 0f,
                    sweepAngle = 360f,
                    useCenter = false,
                    size = size,
                    style = Stroke(
                        width = strokeWidth.toPx(),
                        cap = StrokeCap.Round
                    )
                )
                if (completedTasks <= totalTasks) {
                    drawArc(
                        color = colorProgress,
                        startAngle = 90f,
                        sweepAngle = (360f * angleRatio.value),
                        useCenter = false,
                        size = size,
                        style = Stroke(
                            width = strokeWidth.toPx(),
                            cap = StrokeCap.Round
                        )
                    )
                }

            }
            Text(
                text = "${round((completedTasks.toDouble() / totalTasks.toDouble() * 100)).toInt()} %",
                style = typography.headlineSmall,
                color = colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SummaryInfoPreview() {
    MaterialTheme {
        SummaryInfo(
            completedTasks = 5,
            totalTasks = 10
        )
    }
}
