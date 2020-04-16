package domain.repository

import com.oleeja.reditclient.domain.models.RedditTopPost
import io.reactivex.Single

interface TopRedditRepository {

    fun getTopPosts(): Single<List<RedditTopPost>>
}