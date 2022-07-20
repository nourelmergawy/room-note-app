package com.mrg.roomnoteapp

import android.app.Application
import androidx.lifecycle.*
import com.mrg.roomnoteapp.db.Note
import com.mrg.roomnoteapp.db.NoteDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel  (application: Application) : AndroidViewModel(application) {
    // on below line we are creating a variable
    // for our all notes list and repository
    val allNotes : MutableLiveData<List<Note>>
    val repository : Repo

    // on below line we are initializing
    // our dao, repository and all notes
    init {
        val dao = NoteDatabase.getNoteBase(application).dao()
        repository = Repo(dao)

        allNotes =  repository.allNotes.toMutableLiveData()
    }

    // on below line we are creating a new method for deleting a note. In this we are
    // calling a delete method from our repository to delete our note.
    fun deleteNote (note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    // on below line we are creating a new method for updating a note. In this we are
    // calling a update method from our repository to update our note.
//    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
//        repository.update(note)
//    }


    // on below line we are creating a new method for adding a new note to our database
    // we are calling a method from our repository to add a new note.
    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
    fun <T> LiveData<T>.toMutableLiveData(): MutableLiveData<T> {
        val mediatorLiveData = MediatorLiveData<T>()
        mediatorLiveData.addSource(this) {
            mediatorLiveData.value = it
        }
        return mediatorLiveData
    }
}