package com.oleeja.reditclient.data.source.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RedditTopPostEntity(
    @PrimaryKey
    @SerializedName("base")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("subreddit")
    val subreddit: String,
    @SerializedName("postDate")
    val postDate: Long,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
    @SerializedName("rating")
    val rating: Long,
    @SerializedName("commentsCount")
    val commentsCount: Int,
    @SerializedName("url")
    val url: String?,
    @SerializedName("current")
    val current: String?,
    @SerializedName("after")
    val after: String?
)