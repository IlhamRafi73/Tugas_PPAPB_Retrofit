package com.example.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ItemContainerBinding
import com.example.retrofit.model.Data


class HeroAdapter(private val listHero: List<Data>) :
    RecyclerView.Adapter<HeroAdapter.ItemHeroViewHolder>() {
    inner class ItemHeroViewHolder(private val binding: ItemContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val itemImage: ImageView = itemView.findViewById(R.id.imageHero)
        fun bind(data: Data) {
            with(binding) {
                txtHeroName.text = data.title
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemHeroViewHolder {
        val binding =
            ItemContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHeroViewHolder(binding)
    }
    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ItemHeroViewHolder, position: Int) {
        holder.bind(listHero[position])
        Glide.with(holder.itemView.context)
            .load(listHero[position].image)
            .centerCrop()
            .into(holder.itemImage)
    }
}