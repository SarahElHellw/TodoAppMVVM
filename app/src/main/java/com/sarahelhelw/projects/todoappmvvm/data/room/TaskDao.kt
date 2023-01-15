package com.sarahelhelw.projects.todoappmvvm.data.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    //if i tried to insert a task with an existing it it will override it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    // in Room, a function that is returning a flow doesn't
    // need a suspend modifier
    // Flow can be only collected inside a coroutine
    @Query("SELECT * FROM tasks_table")
    fun getTasks(): Flow<List<Task>>
}