package com.mike.commitbrowser.di

import com.mike.commitbrowser.network.GithubApiDataSource
import com.mike.commitbrowser.network.IGithubApiDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class CommitItemApiModule {
    @Binds
    abstract fun bindsGitHubApiDataSource(githubApiDataSource: GithubApiDataSource) : IGithubApiDataSource
}
