package com.mrg.roomnoteapp

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.internal.ContextUtils.getActivity
import com.mrg.roomnoteapp.db.Note
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var btn : FloatingActionButton
    lateinit var viewModal: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.floatingActionButton)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<Note>()

        // This will pass the ArrayList to our Adapter
        val adapter = RecyclerViewAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        // on below line we are
        // initializing our view modal.
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)
        // on below line we are calling all notes method
        // from our view modal class to observer the changes on list.

        val test=intent.getStringExtra("noteBody")
        Log.d(TAG, "onCreate: ${test}")
        viewModal.allNotes.observe(this, Observer { list ->
            list?.let {
                // on below line we are updating our list.

                adapter.updateList(data)
                Log.d(TAG, "onCreate: test2")
                btn.setOnClickListener {

                    callFrag(adapter)

                }
            }
        })

    }

    private fun callFrag(adapter: RecyclerViewAdapter) {
       supportFragmentManager.beginTransaction().add(R.id.fragment_item,AddNoteFragment(adapter)).commit()
        Log.d(TAG, "onCreate: test1")

    }
}