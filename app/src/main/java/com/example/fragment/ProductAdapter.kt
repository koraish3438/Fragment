package com.example.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragment.databinding.ProductItemListBinding

class ProductAdapter(var product: List<ProductModel>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(val binding: ProductItemListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = product[position]
        holder.binding.productName.text = currentItem.title
        holder.binding.productPrice.text = "$${currentItem.price}"
        holder.binding.productRating.text = currentItem.rating.rate.toString()
        holder.binding.productDesc.text = currentItem.description
        Glide.with(holder.itemView.context).load(currentItem.image).into(holder.binding.productImage)
    }

    override fun getItemCount(): Int {
        return product.size
    }
}