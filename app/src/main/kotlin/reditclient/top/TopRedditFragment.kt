package reditclient.top

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.oleeja.reditclient.R
import reditclient.base.BaseFragment


class TopRedditFragment : BaseFragment() {

    private lateinit var viewModel: TopRedditViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_reddit, container, false)
    }
}
