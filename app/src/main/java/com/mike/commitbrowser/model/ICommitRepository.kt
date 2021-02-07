package com.mike.commitbrowser.model

import kotlinx.coroutines.flow.Flow


interface ICommitRepository  {

    suspend fun getCommitItems(): List<CommitItem>

}