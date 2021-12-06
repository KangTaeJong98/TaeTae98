package com.taetae98.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.taetae98.viewmodel.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
//    private val mainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) } // Fragment ViewModel
    private val mainViewModel by lazy { ViewModelProvider(requireActivity()).get(MainViewModel::class.java) } // Activity ViewModel
//    private val mainViewModel by viewModels<MainViewModel>() // Navigation Component를 사용하여 ViewModel 생성
//    private val mainViewModel by activityViewModels<MainViewModel>() // Navigation Component를 사용하여 ActivityViewModel 생성

//    // ViewModel With Parameter
//    private val mainViewModel by lazy {
//        ViewModelProvider(
//            owner = requireActivity(),
//            factory = MainViewModel.Factory(
//                requireActivity().application, this)
//        ).get(MainViewModel::class.java)
//    }

//    // ViewModel With Parameter Navigation Component
//    private val mainViewModel by viewModels<MainViewModel> {
//        MainViewModel.Factory(
//            application = requireActivity().application,
//            owner = requireActivity()
//        )
//    }


    private var _binding: FragmentFirstBinding? = null
    private val binding: FragmentFirstBinding
        get() {
            return _binding!!
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, null, false).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.mainViewModel = mainViewModel
        binding.setOnNext {
            findNavController().navigate(FirstFragmentDirections.actionFirstFragmentToSecondFragment())
        }
    }
}