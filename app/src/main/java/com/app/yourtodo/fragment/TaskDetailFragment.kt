package com.app.yourtodo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.app.yourtodo.R
import com.app.yourtodo.databinding.FragmentTaskDetailBinding
import com.app.yourtodo.extension.toISO
import com.app.yourtodo.model.Work
import com.app.yourtodo.viewmodel.TaskViewModel

class TaskDetailFragment : Fragment() {

    lateinit var binding: FragmentTaskDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)


        TaskViewModel.selected?.let { bind(it) }

        return binding.root
    }

    private fun bind(work: Work) {
        binding.detailTitle.text = work.title
        binding.detailCreatedDate.text = work.startDate?.toISO()
        binding.detailDescription.text = work.description
    }
}