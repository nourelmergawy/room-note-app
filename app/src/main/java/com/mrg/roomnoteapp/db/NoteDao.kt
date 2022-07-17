package com.mrg.roomnoteapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insertAll(Courses: List<Note>)

    @Delete
    suspend fun delete(Course: Note)
}