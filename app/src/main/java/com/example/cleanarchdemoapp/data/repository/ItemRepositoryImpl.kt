package com.example.cleanarchdemoapp.data.repository

import com.example.cleanarchdemoapp.domain.model.Item
import com.example.cleanarchdemoapp.data.remote.ApiService
import com.example.cleanarchdemoapp.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class ItemRepositoryImpl(private val apiService: ApiService) : ItemRepository {
    override fun getItems(): Flow<List<Item>> = flow {
        emit(emptyList<Item>())
        val response = apiService.getItems()
        emit(response)
    }.catch { e -> throw Exception("Failed to fetch items: ${e.message}") }
}