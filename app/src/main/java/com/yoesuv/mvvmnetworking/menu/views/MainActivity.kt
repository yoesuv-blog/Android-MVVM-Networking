package com.yoesuv.mvvmnetworking.menu.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.yoesuv.mvvmnetworking.R
import com.yoesuv.mvvmnetworking.databinding.ActivityMainBinding
import com.yoesuv.mvvmnetworking.menu.adapters.ListPlaceAdapter
import com.yoesuv.mvvmnetworking.menu.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()

        viewModel.getListPlace()
    }

    private fun setupRecyclerView(){
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlace.layoutManager = layoutManager
        adapter = ListPlaceAdapter(this)
        binding.recyclerViewPlace.adapter = adapter
    }

    private fun observeLiveData(){
        viewModel.listPlace.observe(this, Observer {
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }
}
