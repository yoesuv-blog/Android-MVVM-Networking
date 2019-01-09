package com.yoesuv.mvvmnetworking.menu.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.yoesuv.mvvmnetworking.R
import com.yoesuv.mvvmnetworking.databinding.ItemPlaceBinding
import com.yoesuv.mvvmnetworking.menu.models.ListPlaceResponseModel
import com.yoesuv.mvvmnetworking.menu.viewmodels.ItemPlaceViewModel

class ListPlaceAdapter(val context: Context): RecyclerView.Adapter<ListPlaceAdapter.ItemPlaceViewHolder>() {

    private var listPlace: MutableList<ListPlaceResponseModel.PlaceModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemPlaceViewHolder {
        val binding: ItemPlaceBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_place, parent, false)
        return ItemPlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: ItemPlaceViewHolder, position: Int) {
        holder.bindData(listPlace[holder.adapterPosition])
    }

    fun setData(list: MutableList<ListPlaceResponseModel.PlaceModel>){
        this.listPlace = list
    }

    class ItemPlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: ListPlaceResponseModel.PlaceModel){
            val viewModel = ItemPlaceViewModel(model)
            binding.itemPlace = viewModel
        }
    }
}