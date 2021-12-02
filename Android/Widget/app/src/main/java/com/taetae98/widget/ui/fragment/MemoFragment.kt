package com.taetae98.widget.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.taetae98.modules.library.navigation.NavigationFragment
import com.taetae98.widget.R
import com.taetae98.widget.adapter.MemoAdapter
import com.taetae98.widget.databinding.FragmentMemoBinding
import com.taetae98.widget.ui.holder.MemoHolder
import com.taetae98.widget.viewModel.InputViewModel
import com.taetae98.widget.viewModel.MemoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MemoFragment : NavigationFragment<FragmentMemoBinding>(R.layout.fragment_memo) {
    private val memoViewModel by viewModels<MemoViewModel>()
    private val inputViewModel by viewModels<InputViewModel>()
    private val memoAdapter by lazy { MemoAdapter() }

    override fun onBindingCreated() {
        super.onBindingCreated()
        binding.inputViewModel = inputViewModel.apply {
            onAction = { memo ->
                viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                    memoViewModel.insert(memo)
                    inputViewModel.input.postValue("")
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onObserveMemo()
        onCreateRecyclerView()
    }

    private fun onObserveMemo() {
        memoViewModel.findAllLiveData().observe(viewLifecycleOwner) {
            memoAdapter.submitList(it)
        }
    }

    private fun onCreateRecyclerView() {
        binding.adapter = memoAdapter
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                if (viewHolder is MemoHolder) {
                    CoroutineScope(Dispatchers.IO).launch {
                        memoViewModel.deleteById(viewHolder.memo.id)
                    }
                }
            }
        }).attachToRecyclerView(binding.recyclerView)
    }
}