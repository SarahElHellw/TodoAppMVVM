package com.sarahelhelw.projects.todoappmvvm.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sarahelhelw.projects.todoappmvvm.R
import com.sarahelhelw.projects.todoappmvvm.databinding.FragmentTasksBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint // we can't use constructor injection with fragments or activities they can't be constructor injected
class TasksFragment : Fragment(R.layout.fragment_tasks) {

    private val viewModel: TasksViewModel by viewModels() // so called property delegate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //here the layout is already inflated
        //inflated means that the xml is converted to an object
        //as we have already passed the layout xml in the constructor
        //that's why we use the bind method below
        val binding = FragmentTasksBinding.bind(view)
        val tasksAdapter = TasksAdapter()

        binding.apply {
            recyclerViewTasks.apply {
                adapter = tasksAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

        //LiveData observe function needs lifecycleOwner object
        //needed by the LiveData to support lifecycle awareness
        //viewLifeCycleOwner this because we only
        //want to display the list when the view is not destroyed
        viewModel.tasks.observe(viewLifecycleOwner){
            tasksAdapter.submitList(it)
        }
    }
}