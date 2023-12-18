package com.bitcodetech.mvvmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MyViewModelFactory(
    val infoRepository: InfoRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfoViewModel(infoRepository) as T
    }
}