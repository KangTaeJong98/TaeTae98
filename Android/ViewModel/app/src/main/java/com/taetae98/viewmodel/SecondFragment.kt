package com.taetae98.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.taetae98.viewmodel.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val mainViewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) }

    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate<FragmentSecondBinding>(inflater, R.layout.fragment_second, null, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainViewModel = mainViewModel
    }
}