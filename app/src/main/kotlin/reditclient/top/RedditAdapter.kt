package com.oleeja.reditclient.reditclient.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oleeja.reditclient.databinding.ItemLoadingBinding
import com.oleeja.reditclient.databinding.ItemTopPostBinding
import com.oleeja.reditclient.domain.models.RedditTopPost


class RedditAdapter(private val onPostClick: (String) -> Unit?, private val onEnd: () -> Unit) :
    RecyclerView.Adapter<RedditAdapter.RedditItemViewHolder>() {

    private val FOOTER = 101
    private val postList = mutableListOf<RedditTopPost>()
    private var loading = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditItemViewHolder {
        val binding = when (viewType) {
            FOOTER -> ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            else -> ItemTopPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
        return RedditItemViewHolder(binding.root)
    }

    override fun getItemCount() = postList.size + 1

    override fun getItemViewType(position: Int) = when (position) {
        postList.size -> FOOTER
        else -> super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: RedditItemViewHolder, position: Int) {
        if (position != postList.size) {
            DataBindingUtil.getBinding<ItemTopPostBinding>(holder.itemView)?.apply {
                model = postList[position]
                root.setOnClickListener { postList[position].url?.let { onPostClick.invoke(it) } }
            }
        } else {
            DataBindingUtil.getBinding<ItemLoadingBinding>(holder.itemView)
                ?.apply { visibility = loading }
            if (loading) onEnd.invoke()
        }
    }

    fun addItems(list: List<RedditTopPost>) {
        loading = list.isNotEmpty()
        if (list.isEmpty()) {
            notifyItemChanged(postList.size)
        } else {
            val oldSize = postList.size
            postList.addAll(list)
            notifyItemRangeInserted(oldSize, list.size)
        }
    }

    inner class RedditItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}