package com.taetae98.widget.widget.memo

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.taetae98.widget.R
import com.taetae98.widget.util.Logger

class MemoWidgetProvider : AppWidgetProvider() {
    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        Logger.intent("Widget onReceive", intent)
    }
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        val intent = Intent(context, MemoWidgetRemoteViewsService::class.java)
        val remoteViews = RemoteViews(context.packageName, R.layout.widget_memo).apply {
            setRemoteAdapter(R.id.list_view, intent)
        }

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews)
    }
}