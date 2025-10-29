package com.example.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    val _products = MutableLiveData<List<ProductModel>>()
    val products: LiveData<List<ProductModel>> get() = _products

    init {
        refreshProducts()
    }


    fun refreshProducts() {
        viewModelScope.launch {
            fetchProducts()
        }
    }

    private suspend fun fetchProducts() {
        try {
            val response = ApiClient.apiService.getProducts()
            _products.postValue(response)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
