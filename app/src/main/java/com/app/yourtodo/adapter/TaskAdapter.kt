package com.app.yourtodo.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.findFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.app.yourtodo.R
import com.app.yourtodo.database.DatabaseContext
import com.app.yourtodo.extension.toISO
import com.app.yourtodo.fragment.TaskDetailFragment
import com.app.yourtodo.fragment.TaskItemFragment
import com.app.yourtodo.fragment.TodayTaskFragment
import com.app.yourtodo.model.Work
import com.app.yourtodo.repo.WorkDao
import com.app.yourtodo.viewmodel.TaskViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking

class TaskAdapter(var tasks: List<Work>) :
    RecyclerView.Adapter<TaskAdapter.Companion.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_task_item, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    companion object {
        class TaskViewHolder(itemView: View) : View.OnClickListener, View.OnLongClickListener, RecyclerView.ViewHolder(itemView) {

            private val workDao: WorkDao by lazy {
                DatabaseContext.setup(itemView.context).workDao()
            }

            init {
                itemView.setOnClickListener(this)
                itemView.setOnLongClickListener(this)
            }

            var title: TextView = itemView.findViewById(R.id.task_title)
            var createdDate: TextView = itemView.findViewById(R.id.task_created_date)
            var id: Int? = 0
            var description: String = ""

            fun bind(work: Work) {
                title.text = work.title
                createdDate.text = work.startDate?.toISO()
                id = work.id
                description = work.description
            }

            override fun onClick(v: View?) {
                TaskViewModel.selected = Work(id = id, title = title.text.toString(), description = description)
                FragmentManager.findFragment<TodayTaskFragment>(v!!)
                    .parentFragmentManager
                    .commit {
                        setReorderingAllowed(true)
                        replace(R.id.todo_container, TaskDetailFragment())
                        addToBackStack(null)
                    }
            }

            override fun onLongClick(v: View?): Boolean {
                v?.context?.let {
                    AlertDialog.Builder(it)
                        .setTitle("Delete Item")
                        .setMessage("Are you sure?")
                        .setPositiveButton("Yes") { _, _ ->
                            runBlocking {
                                workDao.deleteWorkById(id!!)
                            }
                        }
                        .setNegativeButton("No", null)
                        .show()
                }
                return true
            }
        }
    }
}