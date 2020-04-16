package com.oleeja.reditclient.data.mappers

import com.oleeja.reditclient.domain.models.RedditTopPost
import data.dto.RedditResponse

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