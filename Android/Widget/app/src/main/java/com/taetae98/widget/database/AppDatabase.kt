package com.taetae98.widget.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.taetae98.widget.database.dao.CovidWidgetDao
import com.taetae98.widget.database.dao.MemoDao
import com.taetae98.widget.database.dao.MemoWidgetDao
import com.taetae98.widget.dto.CovidWidget
import com.taetae98.widget.dto.Memo
import com.taetae98.widget.dto.MemoWidget

@Database(
    entities = [
        CovidWidget::class, Memo::class, MemoWidget::class
    ], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context, AppDatabase::class.java, "AppDB.db"
                ).build().also {
                    instance = it
                }
            }
        }
    }

    abstract fun covidWidgetDao(): CovidWidgetDao
    abstract fun memoDao(): MemoDao
    abstract fun memoWidgetDao(): MemoWidgetDao
}