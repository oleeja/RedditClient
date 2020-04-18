package com.oleeja.reditclient.data.source.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * The Room database that contains the Users table
 */
@Database(
    entities = [RedditTopPostEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RedditDatabase : RoomDatabase() {

    abstract fun redditTopDao(): RedditTopDao

    companion object {

        @Volatile
        private var INSTANCE: RedditDatabase? = null

        fun getInstance(context: Context): RedditDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                RedditDatabase::class.java, "ReditTopBase.db"
            )
                .build()
    }
}
