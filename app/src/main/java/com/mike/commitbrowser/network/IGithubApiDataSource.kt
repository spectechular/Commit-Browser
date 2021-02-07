package com.mike.commitbrowser.network

import com.mike.commitbrowser.model.CommitItem

interface IGithubApiDataSource {

    suspend fun getCommits(): List<CommitItem>
}