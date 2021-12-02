package com.taetae98.widget.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.taetae98.modules.library.base.BaseRecyclerViewAdapter
import com.taetae98.modules.library.base.BaseViewHolder
import com.taetae98.widget.databinding.HolderMemoBinding
import com.taetae98.widget.dto.Memo
import com.taetae98.widget.ui.holder.MemoHolder

class MemoAdapter : BaseRecyclerViewAdapter<Memo>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Memo> {
        return MemoHolder(
            HolderMemoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private class DiffCallback : DiffUtil.ItemCallback<Memo>() {
        override fun areItemsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Memo, newItem: Memo): Boolean {
            return oldItem == newItem
        }
    }
}