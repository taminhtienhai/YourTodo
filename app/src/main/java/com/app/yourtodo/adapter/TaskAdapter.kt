package com.app.yourtodo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.app.yourtodo.R
import com.app.yourtodo.database.DatabaseContext
import com.app.yourtodo.extension.toISO
import com.app.yourtodo.model.Work
import com.app.yourtodo.repo.WorkDao
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

            fun bind(work: Work) {
                title.text = work.title
                createdDate.text = work.startDate?.toISO()
                id = work.id
            }

            override fun onClick(v: View?) {

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