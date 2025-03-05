package com.example.cleanarchdemoapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarchdemoapp.data.remote.ApiService
import com.example.cleanarchdemoapp.data.repository.ItemRepositoryImpl
import com.example.cleanarchdemoapp.domain.usecase.FetchItemsUseCase
import com.example.cleanarchdemoapp.presentation.viewmodel.MainViewModel

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(FetchItemsUseCase(ItemRepositoryImpl(ApiService.create()))) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}