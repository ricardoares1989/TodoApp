package com.juandgaines.todoapp.data.local.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import com.juandgaines.todoapp.data.local.TodoAppDatabase
import com.juandgaines.todoapp.data.local.task.TaskDao
import com.juandgaines.todoapp.data.local.task.TaskEntity
import com.juandgaines.todoapp.domain.Task
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.UUID

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideRoomDatabase(
        @ApplicationContext
        context: Context,
        applicationScope:CoroutineScope,
        task: TaskDao
    ): TodoAppDatabase {
        return Room.databaseBuilder(
            context,
            TodoAppDatabase::class.java,
            "todo_app_database"
        ).addCallback( object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                applicationScope.launch {
                    task.saveTask(TaskEntity(
                        id = UUID.randomUUID().toString(),
                        title = "Title 1",
                        description = "Description 1",
                        isCompleted = false,
                        category = 0
                    ))
                }
            }
        })
            .build()
    }

    @Provides
    fun provideTodoDao(
        roomDatabase: TodoAppDatabase
    ): TaskDao {
        return roomDatabase.taskDao()
    }
}