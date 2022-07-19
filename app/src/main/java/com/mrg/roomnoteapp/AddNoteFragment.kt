package com.mrg.roomnoteapp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mrg.roomnoteapp.db.Note

class AddNoteFragment(val adpater : RecyclerViewAdapter) : Fragment() {
    lateinit var viewModal: NoteViewModel
    lateinit var addBtn : Button
    lateinit var etext : EditText
     var mList: ArrayList<Note> ?=null
    lateinit var note : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_add_note, container, false)


        addBtn = view.findViewById<Button>(R.id.button)
        etext =  view.findViewById<EditText>(R.id.editTextTextPersonName)
        addBtn!!.setOnClickListener {
            note = etext.text.toString()
            // This will pass the ArrayList to our Adapter
            Toast.makeText(context,note,LENGTH_LONG).show()
            val intent = Intent(activity, MainActivity::class.java)
            intent.putExtra("noteBody",note)
            startActivity(intent)
        }
        return view
    }
//    fun callAct(){
//
//    }
}