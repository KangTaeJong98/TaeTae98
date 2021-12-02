package com.taetae98.widget.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.taetae98.modules.library.base.BaseDao
import com.taetae98.widget.dto.MemoWidget

@Dao
interface MemoWidgetDao : BaseDao<MemoWidget> {
    @Query("SELECT * FROM MemoWidget")
    suspend fun findAll(): List<MemoWidget>
}