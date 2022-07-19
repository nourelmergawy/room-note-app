package com.mrg.roomnoteapp.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun getAll(): LiveData<List<Note>>

    @Insert
    suspend fun insertAll(note: List<Note>)

    @Delete
    suspend fun delete(note: Note)

    @Insert
    suspend fun insert(note: Note)

}