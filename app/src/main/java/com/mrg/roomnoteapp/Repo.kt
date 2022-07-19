package com.mrg.roomnoteapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mrg.roomnoteapp.db.Note
import com.mrg.roomnoteapp.db.NoteDao

class Repo(private val notesDao: NoteDao) {
    // on below line we are creating a variable for our list
    // and we are getting all the notes from our DAO class.
    val allNotes: LiveData<List<Note>> = notesDao.getAll()

    // on below line we are creating an insert method
    // for adding the note to our database.
    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    // on below line we are creating a delete method
    // for deleting our note from database.
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    // on below line we are creating a update method for
    // updating our note from database.
//    suspend fun update(note: Note){
//        notesDao.update(note)
//    }
}