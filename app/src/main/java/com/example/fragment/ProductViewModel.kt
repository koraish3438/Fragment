package com.example.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel: ViewModel() {
    val products = MutableLiveData<List<ProductModel>>()
    val productS: LiveData<List<ProductModel>> get() = products
}
