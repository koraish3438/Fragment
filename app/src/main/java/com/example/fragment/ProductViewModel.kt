package com.example.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    val products = MutableLiveData<List<ProductModel>>()
    val productS: LiveData<List<ProductModel>> get() = products

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
            products.postValue(response)
        }
        catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
