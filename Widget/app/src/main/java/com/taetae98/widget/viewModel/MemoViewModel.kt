package com.taetae98.widget.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.taetae98.widget.dto.Memo
import com.taetae98.widget.repository.MemoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemoViewModel @Inject constructor(
    private val memoRepository: MemoRepository
) : ViewModel() {
    suspend fun insert(memo: String): Long {
        return memoRepository.insert(Memo(memo = memo))
    }

    suspend fun deleteById(id: Int): Int {
        return memoRepository.deleteById(id)
    }

    fun findAllLiveData(): LiveData<List<Memo>> {
        return memoRepository.findAllLiveData()
    }
}