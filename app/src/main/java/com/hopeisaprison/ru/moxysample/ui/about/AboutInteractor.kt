package com.hopeisaprison.ru.moxysample.ui.about

import com.hopeisaprison.ru.moxysample.data.network.GithubApi
import com.hopeisaprison.ru.moxysample.data.network.model.Repository
import com.hopeisaprison.ru.moxysample.ui.base.BaseInteractor
import javax.inject.Inject

class AboutInteractor @Inject constructor(githubApi: GithubApi) : BaseInteractor(githubApi), IAboutInteractor {

    override fun getUserRepos() = githubApi.getRepos("ivametal")
}