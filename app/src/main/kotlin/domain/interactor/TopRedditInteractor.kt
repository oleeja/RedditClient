package domain.interactor

import com.oleeja.reditclient.domain.models.RedditTopPost
import domain.repository.TopRedditRepository
import io.reactivex.Single

class TopRedditInteractor(private val topRedditRepository: TopRedditRepository) {
    fun getTopPosts(): Single<List<RedditTopPost>>{
        return topRedditRepository.getTopPosts()
    }
}