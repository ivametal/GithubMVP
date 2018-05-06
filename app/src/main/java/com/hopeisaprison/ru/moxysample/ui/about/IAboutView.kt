package com.hopeisaprison.ru.moxysample.ui.about

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.hopeisaprison.ru.moxysample.data.network.model.Repository
import com.hopeisaprison.ru.moxysample.ui.base.IBaseView

/**
 * Created by hopeisaprison on 18.03.18.
 */
interface IAboutView : IBaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showUserRepos(reposList: List<Repository>)

}