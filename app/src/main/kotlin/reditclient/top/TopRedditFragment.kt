package reditclient.top

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.Observer
import com.oleeja.reditclient.databinding.FragmentTopRedditBinding
import com.oleeja.reditclient.reditclient.top.RedditAdapter
import com.oleeja.reditclient.reditclient.utils.CustomTabHelper
import kotlinx.android.synthetic.main.fragment_top_reddit.*
import org.koin.androidx.scope.currentScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import reditclient.base.BaseFragment


class TopRedditFragment : BaseFragment() {

    private val topRedditViewModel: TopRedditViewModel by currentScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentTopRedditBinding.inflate(inflater, container, false).also {
        lifecycle.addObserver(topRedditViewModel)
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RedditAdapter(customTabCallback, {topRedditViewModel.loadItems()})
        topRedditRecycler.adapter = adapter
        topRedditViewModel.postData.observe(viewLifecycleOwner, Observer { result ->
            adapter.addItems(result)
        })
    }

    private val customTabCallback = { url: String ->
        context?.let {
            CustomTabHelper().getPackageNameToUse(it, url)?.let { packageName ->
                val customTabsIntent = CustomTabsIntent.Builder().build()
                customTabsIntent.intent.setPackage(packageName)
                customTabsIntent.launchUrl(it, Uri.parse(url))
            }
        }
    }
}
