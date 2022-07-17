package com.mrg.roomnoteapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val noteId: Int,
    @ColumnInfo()var body : String

)
