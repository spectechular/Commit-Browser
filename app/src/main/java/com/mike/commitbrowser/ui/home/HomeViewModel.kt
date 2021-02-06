package com.mike.commitbrowser.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

     val text = MutableLiveData<String>().apply {
        value = "Commits"
    }
}