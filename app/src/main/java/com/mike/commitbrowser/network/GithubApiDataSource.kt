package com.mike.commitbrowser.network

import com.mike.commitbrowser.model.CommitItem
import retrofit2.Retrofit
import javax.inject.Inject

class GithubApiDataSource @Inject constructor(private val retrofit: Retrofit) :
    IGithubApiDataSource {
    override suspend fun getCommits(): List<CommitItem> {
        val apiDataSource = retrofit.create(GithubService::class.java)
        return apiDataSource.getCommits()
    }
}