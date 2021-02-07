package com.mike.commitbrowser.network

import com.mike.commitbrowser.model.CommitItem
import retrofit2.http.GET


interface GithubService{
    @GET("/repos/spectechular/test-no-commits-on-repo/commits")
    suspend fun getCommits() : List<CommitItem>

}


