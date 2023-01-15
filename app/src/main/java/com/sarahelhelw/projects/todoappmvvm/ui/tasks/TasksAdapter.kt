package com.sarahelhelw.projects.todoappmvvm.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sarahelhelw.projects.todoappmvvm.data.room.Task
import com.sarahelhelw.projects.todoappmvvm.databinding.ItemTaskBinding

class TasksAdapter : ListAdapter<Task, TasksAdapter.TaskViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task)
    }

    //this is a nested class
    class TaskViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.apply {
                textViewTaskName.text = task.name
                textViewTaskName.paint.isStrikeThruText = task.completed
                checkBoxCompleted.isChecked = task.completed
                imageViewPriority.isVisible = task.important
            }
        }
    }

    // this is a nested class
    class DiffUtilCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem
    }
}