package com.oleeja.reditclient.data.source.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
abstract class RedditTopDao {
    @Query("SELECT * FROM RedditTopPostEntity WHERE `current` = :current ")
    abstract fun getTopList(current: String): Single<List<RedditTopPostEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract fun insertTopPosts(model: List<RedditTopPostEntity>): Completable
}