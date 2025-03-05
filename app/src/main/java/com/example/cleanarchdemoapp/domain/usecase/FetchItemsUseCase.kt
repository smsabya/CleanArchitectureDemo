package com.example.cleanarchdemoapp.domain.usecase

import com.example.cleanarchdemoapp.domain.model.Item
import com.example.cleanarchdemoapp.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class FetchItemsUseCase(private val repository: ItemRepository) {
    operator fun invoke(): Flow<List<Item>> = repository.getItems()
}