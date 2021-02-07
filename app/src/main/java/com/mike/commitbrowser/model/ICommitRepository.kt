package com.mike.commitbrowser.model

interface ICommitRepository  {

    suspend fun getCommitItems(): List<CommitItem>

}