package com.sarahelhelw.projects.todoappmvvm.ui.tasks

import androidx.lifecycle.ViewModel
import com.sarahelhelw.projects.todoappmvvm.data.room.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskDao: TaskDao
) : ViewModel() {
}