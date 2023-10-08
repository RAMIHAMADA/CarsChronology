package com.rami.taxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rami.taxi.R
import com.rami.taxi.databinding.ItemImageViewPagerBinding

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    private val urlList: MutableList<String> = mutableListOf()

    class ViewPagerHolder(private val binding: ItemImageViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(url: String) {
            Glide.with(itemView.context)
                .load(url)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.image)
        }
    }

    fun setData(urlList: List<String>) {
        this.urlList.clear()
        this.urlList.addAll(urlList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemImageViewPagerBinding.inflate(inflater, parent, false)
        return ViewPagerHolder(binding)
    }

    override fun getItemCount(): Int = urlList.size

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        holder.bind(urlList[position])
    }
}
