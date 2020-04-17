package com.oleeja.reditclient.reditclient.top

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.oleeja.reditclient.databinding.ItemTopPostBinding
import com.oleeja.reditclient.domain.models.RedditTopPost


class RedditAdapter(val onPostClick: (String) -> Unit?) :
    RecyclerView.Adapter<RedditAdapter.RedditItemViewHolder>() {

    private val redditList = mutableListOf<RedditTopPost>()
    private lateinit var binding: ItemTopPostBinding

    inner class RedditItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditItemViewHolder {
        binding = ItemTopPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RedditItemViewHolder(binding.root)
    }

    override fun getItemCount() = redditList.size

    override fun onBindViewHolder(holder: RedditItemViewHolder, position: Int) {
        binding.model = redditList[position]
        binding.root.setOnClickListener { redditList[position].url?.let { onPostClick.invoke(it) } }
    }

    fun addItems(list: List<RedditTopPost>) {
        val oldSize = redditList.size
        redditList.addAll(oldSize, list)
        notifyItemRangeInserted(oldSize, redditList.size)
    }
}