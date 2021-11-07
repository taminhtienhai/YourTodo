package com.app.yourtodo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.yourtodo.adapter.TaskAdapter
import com.app.yourtodo.database.DatabaseContext
import com.app.yourtodo.databinding.FragmentTodayTaskBinding
import com.app.yourtodo.repo.WorkDao
import kotlinx.coroutines.launch

class TodayTaskFragment : Fragment() {

    lateinit var binding: FragmentTodayTaskBinding;
    private val workDao: WorkDao by lazy {
        DatabaseContext.setup(requireContext()).workDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodayTaskBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            binding.taskList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = TaskAdapter(workDao.loadAllWork())
            }
        }

        return binding.root
    }

}