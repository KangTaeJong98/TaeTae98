package com.taetae98.widget.widget.memo

import android.content.Intent
import android.widget.RemoteViewsService
import com.taetae98.widget.repository.MemoRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MemoWidgetRemoteViewsService : RemoteViewsService() {
    @Inject
    lateinit var memoRepository: MemoRepository

    override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return MemoWidgetRemoteViewsFactory(this, memoRepository)
    }
}