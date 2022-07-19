package com.mrg.roomnoteapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
    @PrimaryKey val noteId: Int,
    @ColumnInfo(name = "body")val body : String?,

)
