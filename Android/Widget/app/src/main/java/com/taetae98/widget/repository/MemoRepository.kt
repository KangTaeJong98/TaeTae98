package com.taetae98.widget.repository

import android.appwidget.AppWidgetManager
import android.content.Context
import androidx.lifecycle.LiveData
import com.taetae98.widget.R
import com.taetae98.widget.database.dao.MemoDao
import com.taetae98.widget.database.dao.MemoWidgetDao
import com.taetae98.widget.dto.Memo
import com.taetae98.widget.dto.MemoWidget
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MemoRepository @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val memoDao: MemoDao,
    private val memoWidgetDao: MemoWidgetDao
) {
    suspend fun findAll(): List<Memo> {
        return memoDao.findAll()
    }

    suspend fun insert(memo: Memo): Long {
        val id = memoDao.insert(memo)
        AppWidgetManager.getInstance(context).notifyAppWidgetViewDataChanged(
            findAllMemoWidget().map { it.id }.toIntArray(), R.id.list_view
        )

        return id
    }

    suspend fun insert(memoWidget: MemoWidget): Long {
        return memoWidgetDao.insert(memoWidget)
    }

    suspend fun deleteById(id: Int): Int {
        val rows = memoDao.deleteById(id)
        AppWidgetManager.getInstance(context).notifyAppWidgetViewDataChanged(
            findAllMemoWidget().map { it.id }.toIntArray(), R.id.list_view
        )

        return rows
    }

    fun findAllLiveData(): LiveData<List<Memo>> {
        return memoDao.findAllLiveData()
    }

    private suspend fun findAllMemoWidget(): List<MemoWidget> {
        return memoWidgetDao.findAll()
    }
}