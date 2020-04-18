package data.source.api

import data.dto.RedditResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RedditService {

    companion object {
        const val ENDPOINT = "https://www.reddit.com"
    }

    @GET("/r/{subreddit}/top.json")
    fun getTop(
        @Path("subreddit") subreddit: String,
        @Query("t") time: String,
        @Query("after") after: String,
        @Query("limit") limit: String,
        @Query("count") count: String
    ): Single<RedditResponse>
}