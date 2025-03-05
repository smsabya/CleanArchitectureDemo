package com.example.cleanarchdemoapp.domain.repository

import com.example.cleanarchdemoapp.domain.model.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getItems(): Flow<List<Item>>
}