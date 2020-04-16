package reditclient.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oleeja.reditclient.R
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import reditclient.base.BaseFragment


class TopRedditFragment : BaseFragment() {

    private val topRedditViewModel: TopRedditViewModel by currentScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lifecycle.addObserver(topRedditViewModel)
        return inflater.inflate(R.layout.fragment_top_reddit, container, false)
    }
}
