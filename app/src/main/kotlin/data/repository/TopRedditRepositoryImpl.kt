package data.repository

import com.oleeja.reditclient.data.mappers.toDomainList
import com.oleeja.reditclient.domain.models.RedditTopPost
import data.dto.RedditResponse
import data.source.api.RedditService
import domain.repository.TopRedditRepository
import io.reactivex.Single

class TopRedditRepositoryImpl(private val redditService: RedditService) : TopRedditRepository {

    override fun getTopPosts(): Single<List<RedditTopPost>>{
         return redditService.getTop("", "2")
             .map(RedditResponse::toDomainList)
    }
}