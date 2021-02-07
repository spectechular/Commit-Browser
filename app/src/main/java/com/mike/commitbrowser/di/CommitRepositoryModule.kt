package com.mike.commitbrowser.di

import com.mike.commitbrowser.model.CommitRepository
import com.mike.commitbrowser.model.ICommitRepository
import dagger.Binds
import dagger.Module

@Module
abstract class CommitRepositoryModule {
    @Binds
    abstract fun bindsCommitRepository(commitRepository: CommitRepository) : ICommitRepository
}