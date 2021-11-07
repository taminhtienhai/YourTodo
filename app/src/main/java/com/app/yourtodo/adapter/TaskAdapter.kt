package com.app.yourtodo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.app.yourtodo.R
import com.app.yourtodo.extension.toISO
import com.app.yourtodo.model.Work

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
        class TaskViewHolder(itemView: View) : View.OnClickListener, RecyclerView.ViewHolder(itemView) {

            init {
                itemView.setOnClickListener(this)
            }

            var title: TextView = itemView.findViewById(R.id.task_title)
            var createdDate: TextView = itemView.findViewById(R.id.task_created_date)

            fun bind(work: Work) {
                title.text = work.title
                createdDate.text = work.startDate?.toISO()
            }

            override fun onClick(v: View?) {
                Toast.makeText(v?.context, "CLick", Toast.LENGTH_SHORT).show()
            }
        }
    }
}