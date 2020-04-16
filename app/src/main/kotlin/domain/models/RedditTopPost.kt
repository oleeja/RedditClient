package com.oleeja.reditclient.domain.models

data class RedditTopPost (
    val id: String,
    val title: String,
    val author: String,
    val subreddit: String,
    val postDate: Long,
    val thumbnailUrl: String,
    val rating: Long,
    val commentsCount: Int,
    val url: String?
)