package com.example.cleanarchdemoapp.presentation.viewmodel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchdemoapp.domain.model.Item
import com.example.cleanarchdemoapp.domain.model.ResultState
import com.example.cleanarchdemoapp.domain.usecase.FetchItemsUseCase
import com.example.cleanarchdemoapp.utils.ErrorUtils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MainViewModel(private val fetchItemsUseCase: FetchItemsUseCase) : ViewModel() {
    private val _items = MutableStateFlow<ResultState<List<Item>>>(ResultState.Loading)
    val items: StateFlow<ResultState<List<Item>>> = _items

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun fetchItems() {
        viewModelScope.launch {
            _items.value = ResultState.Loading
            fetchItemsUseCase()
                .catch { e -> _items.value = ResultState.Error(ErrorUtils.handleException(e)) }
                .collect { data -> _items.value = ResultState.Success(data) }
        }
    }
}