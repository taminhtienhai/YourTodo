package com.app.yourtodo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.app.yourtodo.R
import com.app.yourtodo.database.DatabaseContext
import com.app.yourtodo.databinding.FragmentProfileBinding
import com.app.yourtodo.repo.WorkDao
import kotlinx.coroutines.launch

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val workDao: WorkDao by lazy {
        DatabaseContext.setup(requireContext()).workDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        ViewCompat.setTransitionName(binding.appName, "profile_app_name")
        ViewCompat.setTransitionName(binding.noteBook, "profile_note_book")
        ViewCompat.setTransitionName(binding.pen, "profile_pen")

        val btnTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.submit_transition)

        sharedElementEnterTransition = btnTransition
        sharedElementReturnTransition = btnTransition

        // Navigate to main
        binding.todayTask.setOnClickListener(::navigate)

        lifecycleScope.launch {
            workDao.loadAllWork().count().apply {
                binding.todayTask.text = this.toString()
            }
        }

        return binding.root
    }


    private fun navigate(view: View) {
        parentFragmentManager.commit {
            replace(R.id.fragmentContainerView, TodoFragment())
        }
    }

}