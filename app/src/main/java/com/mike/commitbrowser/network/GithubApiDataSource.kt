package com.mike.commitbrowser.network

import android.util.Log
import com.mike.commitbrowser.model.CommitItem
import retrofit2.Retrofit
import javax.inject.Inject

class GithubApiDataSource @Inject constructor(private val retrofit: Retrofit) :
    IGithubApiDataSource {
    override suspend fun getCommits(): List<CommitItem> {
        Log.d("miker", "in data source api")
        val apiDataSource = retrofit.create(GithubService::class.java)
        return apiDataSource.getCommits()
    }
}