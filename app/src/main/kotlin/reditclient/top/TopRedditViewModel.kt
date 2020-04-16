package reditclient.top

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import domain.interactor.TopRedditInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import reditclient.base.BaseViewModel

class TopRedditViewModel (private val topRedditInteractor: TopRedditInteractor) : BaseViewModel() {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun loadItems() {
        topRedditInteractor.getTopPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("tttag", "")
            }, {})
    }
}
