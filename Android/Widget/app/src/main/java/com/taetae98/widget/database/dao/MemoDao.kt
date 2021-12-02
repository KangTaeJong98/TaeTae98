package com.taetae98.widget.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.taetae98.modules.library.base.BaseDao
import com.taetae98.widget.dto.Memo

@Dao
interface MemoDao : BaseDao<Memo> {
    @Query("SELECT * FROM Memo")
    suspend fun findAll(): List<Memo>

    @Query("DELETE FROM Memo WHERE id=:id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM Memo")
    fun findAllLiveData(): LiveData<List<Memo>>
}