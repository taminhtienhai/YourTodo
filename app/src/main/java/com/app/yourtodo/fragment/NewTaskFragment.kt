package com.app.yourtodo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.lifecycleScope
import com.app.yourtodo.R
import com.app.yourtodo.database.DatabaseContext
import com.app.yourtodo.databinding.FragmentNewTaskBinding
import com.app.yourtodo.extension.hideKeyboard
import com.app.yourtodo.model.Work
import com.app.yourtodo.repo.WorkDao
import kotlinx.coroutines.launch

class NewTaskFragment : Fragment() {

    lateinit var binding: FragmentNewTaskBinding
    val workDao: WorkDao by lazy {
        DatabaseContext.setup(requireContext()).workDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)

        binding.newTaskView.setOnClickListener {
            it.hideKeyboard()
        }

        binding.addTask.setOnClickListener {
            lifecycleScope.launch {
                workDao.addWorks(collectTask())
            }
        }

        return binding.root
    }

    private fun collectTask(): Work {
        val title = binding.newTaskTitle.text.toString()
        val description = binding.newTaskDescription.text.toString()
        return Work(title = title, description = description)
    }
}