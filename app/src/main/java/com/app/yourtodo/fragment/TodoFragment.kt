package com.app.yourtodo.fragment

import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.app.yourtodo.R
import com.app.yourtodo.databinding.FragmentTodoBinding


class TodoFragment : Fragment() {

    lateinit var binding: FragmentTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoBinding.inflate(inflater, container, false)

        val navController = childFragmentManager.findFragmentById(R.id.todo_container)?.findNavController()
        NavigationUI.setupWithNavController(binding.todoNav, navController!!)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.create_new_task) {
            binding.todoMain.transitionToStart()
            binding.todoMain.transitionToEnd()
        }

        return super.onOptionsItemSelected(item)
    }
}