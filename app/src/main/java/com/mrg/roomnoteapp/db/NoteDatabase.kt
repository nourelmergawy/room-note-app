package com.mrg.roomnoteapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1)
abstract class NoteDatabase() : RoomDatabase() {
    abstract fun dao(): NoteDao

    companion object {
        @Volatile
        private var INSTANCE: NoteDatabase? = null
        fun getCoinBase(context: Context): NoteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "coin_database"
                )
                    .build()
                INSTANCE = instance
                return instance
                //instance
            }

        }
    }
}