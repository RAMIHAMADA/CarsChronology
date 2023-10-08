package com.rami.taxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rami.taxi.R
import com.rami.taxi.databinding.ItemPostBinding
import com.rami.taxi.models.PostModel

class PostAdapter : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private val postList: MutableList<PostModel> = mutableListOf()

    class PostViewHolder(private val binding: ItemPostBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostModel) {
            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.image)
            binding.date.text = item.date
            binding.description.text = item.text
            binding.favoriteCount.text = item.likeCount.toString()
            binding.commentCount.text = item.commentCount.toString()
        }
    }

    fun setData(postList: List<PostModel>) {
        this.postList.clear()
        this.postList.addAll(postList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPostBinding.inflate(inflater, parent, false)
        return PostViewHolder(binding)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(postList[position])
    }
}
