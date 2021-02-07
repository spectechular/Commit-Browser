package com.mike.commitbrowser.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.mike.commitbrowser.model.CommitItem
import com.mike.commitbrowser.model.ICommitRepository
import kotlinx.coroutines.launch

import javax.inject.Inject


class HomeViewModel @Inject constructor(private var repository: ICommitRepository) : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "Commits"
    }
    private val _commits= MutableLiveData<List<CommitItem>>()
    val commits : LiveData<List<CommitItem>> get() = _commits

    fun reactToButtonPress() {
        viewModelScope.launch {
            _commits.value = repository.getCommitItems()
            Log.d("miker", repository.toString())
            Log.d("miker", commits.toString())
        }
    }

}