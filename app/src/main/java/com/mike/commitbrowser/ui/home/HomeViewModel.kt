package com.mike.commitbrowser.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mike.commitbrowser.network.GithubService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject


class HomeViewModel @Inject constructor(private var retrofit: Retrofit) : ViewModel() {

    val text = MutableLiveData<String>().apply {
        value = "Commits"
    }


    fun reactToButtonPress(){
        CoroutineScope(Dispatchers.IO).launch {
            val client: GithubService = retrofit.create(GithubService::class.java)
            Log.d("miker", "in netcall fun")
            var response = client.getCommits()
            Log.d("miker", response.toString())
        }
    }

}