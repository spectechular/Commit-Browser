package com.mike.commitbrowser.model

import com.mike.commitbrowser.network.IGithubApiDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommitRepository  @Inject constructor(
    private val githubApiDataSource: IGithubApiDataSource
) : ICommitRepository{

    override suspend fun getCommitItems(): List<CommitItem> {
        return githubApiDataSource.getCommits()
    }
}