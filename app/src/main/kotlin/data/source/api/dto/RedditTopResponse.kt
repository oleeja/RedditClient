package data.source.api.dto

import com.google.gson.annotations.SerializedName

data class RedditResponse(
    @SerializedName("data")
    val data: RedditDataResponse
)

data class RedditDataResponse(
    @SerializedName("children")
    val children: List<RedditChildrenResponse>,
    @SerializedName("after")
    val after: String?,
    @SerializedName("before")
    val before: String?
)

data class RedditChildrenResponse(
    @SerializedName("data")
    val data: RedditNewsDataResponse
)

data class RedditNewsDataResponse(
    @SerializedName("id")
    val id: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("subreddit")
    val subreddit: String,
    @SerializedName("num_comments")
    val numComments: Int,
    @SerializedName("created")
    val created: Long,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("score")
    val score: Long,
    @SerializedName("url")
    val url: String?
)