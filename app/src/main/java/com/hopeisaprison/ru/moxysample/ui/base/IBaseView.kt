package com.hopeisaprison.ru.moxysample.ui.base

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * Created by hopeisaprison on 04.03.18.
 */
interface IBaseView : MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun showToast(msg: String)

    @StateStrategyType(SkipStrategy::class)
    fun showError(msg: String)
}