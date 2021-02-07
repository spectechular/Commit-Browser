package com.mike.commitbrowser.network

import java.io.IOException

data class GithubCommitServiceException constructor(val throwable: Throwable?, val specificMessage: String = ""): IOException()