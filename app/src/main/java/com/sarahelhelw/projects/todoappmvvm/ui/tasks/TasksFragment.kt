package com.sarahelhelw.projects.todoappmvvm.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sarahelhelw.projects.todoappmvvm.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // we can't use constructor injection with fragments or activities they can't be constructor injected
class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel: TasksViewModel by viewModels() // so called property delegate
}