package com.taetae98.widget.widget.memo

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.taetae98.widget.R
import com.taetae98.widget.dto.Memo
import com.taetae98.widget.repository.MemoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class MemoWidgetRemoteViewsFactory(
    private val context: Context,
    private val memoRepository: MemoRepository
) : RemoteViewsService.RemoteViewsFactory {
    private var list = emptyList<Memo>()

    override fun onCreate() {

    }

    override fun onDataSetChanged() {
        runBlocking(Dispatchers.IO) {
            list = memoRepository.findAll()
        }
    }

    override fun onDestroy() {

    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        return RemoteViews(context.packageName, R.layout.widget_memo_remotes_view).apply {
            setTextViewText(R.id.memo_text_view, list[position].memo)
        }
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return list[position].id.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }
}