package com.example.cleanarchdemoapp.presentation.ui

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchdemoapp.R
import com.example.cleanarchdemoapp.di.ViewModelFactory
import com.example.cleanarchdemoapp.domain.model.ResultState
import com.example.cleanarchdemoapp.presentation.adapters.ItemAdapter
import com.example.cleanarchdemoapp.presentation.viewmodel.MainViewModel
import com.example.cleanarchdemoapp.utils.ToastUtils
import com.example.cleanarchdemoapp.utils.ViewUtils.hide
import com.example.cleanarchdemoapp.utils.ViewUtils.show
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ItemAdapter
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this, ViewModelFactory())[MainViewModel::class.java]
        //viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        adapter = ItemAdapter()
        progressBar = findViewById(R.id.progressBar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        observeData()
        viewModel.fetchItems()
    }

    private fun observeData() {
        lifecycleScope.launch {
            viewModel.items.collect { result ->
                when (result) {
                    is ResultState.Loading -> progressBar.show()
                    is ResultState.Success -> {
                        progressBar.hide()
                        adapter.submitList(result.data)
                    }

                    is ResultState.Error -> {
                        progressBar.hide()
                        ToastUtils.showToast(this@MainActivity, result.message)
                    }
                }
            }
        }
    }
}