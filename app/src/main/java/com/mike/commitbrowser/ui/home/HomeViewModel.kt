package com.mike.commitbrowser.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.mike.commitbrowser.model.CommitItem
import com.mike.commitbrowser.model.ICommitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject


class HomeViewModel @Inject constructor(private var repository: ICommitRepository) : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "Commits"
    }



    fun reactToButtonPress(){
        viewModelScope.launch {
            var commits = repository.getCommitItems()
            Log.d("miker", repository.toString())
            Log.d("miker", commits.toString())
        }
    }

}