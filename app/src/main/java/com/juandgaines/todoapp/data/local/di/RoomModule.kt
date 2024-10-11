package com.juandgaines.todoapp.data.local.di

import android.content.Context
import androidx.room.Room
import com.juandgaines.todoapp.data.local.TodoAppDatabase
import com.juandgaines.todoapp.data.local.task.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Provides
    fun provideRoomDatabase(
        @ApplicationContext
        context: Context
    ): TodoAppDatabase {
        return Room.databaseBuilder(
            context,
            TodoAppDatabase::class.java,
            "todo_app_database"
        ).build()
    }

    @Provides
    fun provideTodoDao(
        roomDatabase: TodoAppDatabase
    ): TaskDao {
        return roomDatabase.taskDao()
    }
}