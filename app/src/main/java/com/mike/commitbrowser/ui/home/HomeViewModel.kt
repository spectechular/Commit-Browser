package com.mike.commitbrowser.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.mike.commitbrowser.model.CommitItem
import com.mike.commitbrowser.model.ICommitRepository
import kotlinx.coroutines.launch
import java.lang.Exception

import javax.inject.Inject


class HomeViewModel @Inject constructor(private var repository: ICommitRepository) : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "Commits"
    }
    private val _commits = MutableLiveData<List<CommitItem>>()
    val commits: LiveData<List<CommitItem>> get() = _commits

    init {
        loadCommits()
    }

    private fun loadCommits() {
        viewModelScope.launch {
            _commits.value = repository.getCommitItems()
        }
    }

}