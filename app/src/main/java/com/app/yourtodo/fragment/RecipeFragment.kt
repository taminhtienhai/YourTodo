package com.app.yourtodo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.yourtodo.R
import com.app.yourtodo.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {

    lateinit var binding: FragmentRecipeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)

        return binding.root
    }

}