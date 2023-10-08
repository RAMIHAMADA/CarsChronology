package com.rami.taxi.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rami.taxi.R
import com.rami.taxi.databinding.ItemListOfCarBinding
import com.rami.taxi.models.CarForListModel

class CarListAdapter(private val onClick: (Long) -> Unit) :
    RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {
    private val dataList: MutableList<CarForListModel> = mutableListOf()

    class CarListViewHolder(private val binding: ItemListOfCarBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CarForListModel) {
            binding.title.text = item.name
            Glide.with(itemView.context)
                .load(item.urlPhoto)
                .placeholder(R.drawable.ic_placeholder)
                .into(binding.picture)
        }
    }

    fun setData(dataList: List<CarForListModel>) {
        this.dataList.clear()
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CarListAdapter.CarListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListOfCarBinding.inflate(inflater, parent, false)
        return CarListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarListAdapter.CarListViewHolder, position: Int) {
        holder.bind(dataList[position])
        holder.itemView.setOnClickListener {
            onClick(dataList[position].id)
        }
    }

    override fun getItemCount(): Int = dataList.size
}
