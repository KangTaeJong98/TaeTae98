package com.taetae98.widget.ui.holder

import com.taetae98.modules.library.base.BaseViewHolder
import com.taetae98.widget.databinding.HolderMemoBinding
import com.taetae98.widget.dto.Memo

class MemoHolder(
    private val binding: HolderMemoBinding
) : BaseViewHolder<Memo>(binding.root) {
    lateinit var memo: Memo

    override fun onBindViewHolder(item: Memo) {
        super.onBindViewHolder(item)
        memo = item
        binding.memo = item
    }
}