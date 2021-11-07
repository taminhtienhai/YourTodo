package com.app.yourtodo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.yourtodo.R
import com.app.yourtodo.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {

    lateinit var binding: FragmentTaskDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)

        return binding.root
    }
}