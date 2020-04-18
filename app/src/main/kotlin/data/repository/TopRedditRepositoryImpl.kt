package data.repository

import com.oleeja.reditclient.data.mappers.toDomainList
import com.oleeja.reditclient.data.source.data.RedditListParametersProvider
import data.dto.RedditResponse
import data.source.api.RedditService
import domain.repository.TopRedditRepository
import io.reactivex.Single

class TopRedditRepositoryImpl(
    private val redditService: RedditService,
    private val parametersProvider: RedditListParametersProvider
) : TopRedditRepository {

    override fun getTopPosts() =
        if (parametersProvider.maxCount == 0) Single.just(emptyList())
        else redditService.getTop(
            parametersProvider.subreddit,
            parametersProvider.time,
            parametersProvider.after,
            parametersProvider.countOnPage.toString(),
            parametersProvider.maxCount.toString()
        ).doOnSuccess {
            parametersProvider.after = it.data.after.orEmpty()
            parametersProvider.maxCount -= it.data.children.size
        }.map(RedditResponse::toDomainList)
}