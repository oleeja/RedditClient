package data.source.api

import data.dto.RedditResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditService {

    companion object {
        const val ENDPOINT = "https://www.reddit.com"
    }

    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String): Single<RedditResponse>
}