package com.app.yourtodo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.app.yourtodo.R
import com.app.yourtodo.databinding.FragmentWelcomeBinding
import com.app.yourtodo.util.LocalReader
import java.io.File
import java.nio.charset.Charset


class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        ViewCompat.setTransitionName(binding.appName, "welcome_app_name")
        ViewCompat.setTransitionName(binding.noteBook, "welcome_note_book")
        ViewCompat.setTransitionName(binding.pen, "welcome_pen")

        binding.welcomeSubmit.setOnClickListener(::transition)

        return binding.root
    }

    private fun transition(view: View?) {
        parentFragmentManager.commit {
            addSharedElement(binding.appName, "profile_app_name")
            addSharedElement(binding.noteBook, "profile_note_book")
            addSharedElement(binding.pen, "profile_pen")
            replace(R.id.fragmentContainerView, ProfileFragment())
        }
    }
}