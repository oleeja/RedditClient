package reditclient.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.functions.Consumer

abstract class BaseViewModel : ViewModel(), LifecycleObserver {
    val error by lazy {
        MutableLiveData<String>()
    }

    val errorHandler = Consumer<Throwable> { it.message?.let { cause -> error.postValue(cause) } }
}