package reditclient.top

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.oleeja.reditclient.domain.models.RedditTopPost
import domain.interactor.TopRedditInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import reditclient.base.BaseViewModel

class TopRedditViewModel (private val topRedditInteractor: TopRedditInteractor) : BaseViewModel() {

    val postData by lazy {
        MutableLiveData<List<RedditTopPost>>()
    }

    val disposable = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun loadItems() {
        disposable.add(topRedditInteractor.getTopPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                postData.postValue(it)
            }, {})
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}
