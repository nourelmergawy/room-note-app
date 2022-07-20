package com.mrg.roomnoteapp.db

import android.view.autofill.AutofillId
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "noteId")
     val noteId: Int,
    @ColumnInfo(name = "body")val body : String?,

)
