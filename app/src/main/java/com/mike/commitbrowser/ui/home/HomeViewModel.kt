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

    private val _errorState = MutableLiveData<Boolean>(false)
    val errorState: LiveData<Boolean> get() = _errorState

    private val _loadingState = MutableLiveData<Boolean>(false)
    val loadingState: LiveData<Boolean> get() = _loadingState

    init {
        loadCommits()
    }

    private fun loadCommits() {
        _errorState.value = false
        _loadingState.value = true
        try {
            viewModelScope.launch {
                _commits.value = repository.getCommitItems()
            }
        } catch (throwable: Throwable){
            _errorState.value = true
        }
        finally {
            _loadingState.value = false
        }

    }

}