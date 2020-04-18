package data.repository

import com.oleeja.reditclient.data.mappers.toDatabaseEntity
import com.oleeja.reditclient.data.mappers.toDomainList
import com.oleeja.reditclient.data.source.data.RedditListParametersProvider
import com.oleeja.reditclient.data.source.storage.RedditTopDao
import data.source.api.RedditService
import data.source.api.dto.RedditResponse
import domain.repository.TopRedditRepository
import io.reactivex.Single

class TopRedditRepositoryImpl(
    private val redditService: RedditService,
    private val parametersProvider: RedditListParametersProvider,
    private val redditTopDao: RedditTopDao
) : TopRedditRepository {

    override fun getTopPosts() =
        if (parametersProvider.maxCount == 0) Single.just(emptyList())
        else redditService.getTop(
            parametersProvider.subreddit,
            parametersProvider.time,
            parametersProvider.after,
            parametersProvider.countOnPage.toString()
        ).doOnSuccess {
            parametersProvider.after = it.data.after.orEmpty()
            parametersProvider.maxCount -= it.data.children.size
        }.map(RedditResponse::toDomainList)
            .flatMap {
                redditTopDao.insertTopPosts(
                    it.toDatabaseEntity(
                        parametersProvider.current,
                        parametersProvider.after
                    )
                )
                    .andThen(Single.just(it))
            }.doOnSuccess { parametersProvider.current = parametersProvider.after }
            .onErrorResumeNext {
                redditTopDao.getTopList(parametersProvider.current).map {
                    if (it.isNotEmpty()) {
                        parametersProvider.current = it[0].after.orEmpty()
                        it.toDomainList()
                    } else {
                        emptyList()
                    }
                }
            }
}