package com.app.yourtodo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.yourtodo.databinding.FragmentTaskItemBinding

class TaskItemFragment : Fragment() {

    lateinit var binding: FragmentTaskItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskItemBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

}