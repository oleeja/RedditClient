package com.oleeja.reditclient.data.mappers

import com.oleeja.reditclient.data.source.storage.RedditTopPostEntity
import com.oleeja.reditclient.domain.models.RedditTopPost
import data.source.api.dto.RedditResponse

fun RedditResponse.toDomainList(): List<RedditTopPost> {
    val topPostList = ArrayList<RedditTopPost>(data.children.size)
    data.children.forEach {
        topPostList.add(
            RedditTopPost(
                it.data.id,
                it.data.title,
                it.data.author,
                it.data.subreddit,
                it.data.created,
                it.data.thumbnail,
                it.data.score,
                it.data.numComments,
                it.data.url
            )
        )
    }
    return topPostList
}

fun List<RedditTopPostEntity>.toDomainList(): List<RedditTopPost> {
    val topPostList = ArrayList<RedditTopPost>(size)
    forEach {
        topPostList.add(
            RedditTopPost(
                it.id,
                it.title,
                it.author,
                it.subreddit,
                it.postDate,
                it.thumbnailUrl,
                it.rating,
                it.commentsCount,
                it.url
            )
        )
    }
    return topPostList
}

fun List<RedditTopPost>.toDatabaseEntity(
    current: String,
    after: String
): List<RedditTopPostEntity> {
    val topPostEntityList = ArrayList<RedditTopPostEntity>(size)
    forEach {
        topPostEntityList.add(
            RedditTopPostEntity(
                it.id,
                it.title,
                it.author,
                it.subreddit,
                it.postDate,
                it.thumbnailUrl,
                it.rating,
                it.commentsCount,
                it.url,
                current,
                after
            )
        )
    }
    return topPostEntityList
}