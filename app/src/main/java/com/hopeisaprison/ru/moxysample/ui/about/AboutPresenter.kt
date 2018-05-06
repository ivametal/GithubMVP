package com.hopeisaprison.ru.moxysample.ui.about

import com.arellomobile.mvp.InjectViewState
import com.hopeisaprison.ru.moxysample.ui.base.BasePresenter
import com.hopeisaprison.ru.moxysample.ui.signin.SignInInteractor
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

@InjectViewState
class AboutPresenter(val mCompositeDisposable: CompositeDisposable,val mAboutInteractor: AboutInteractor) :
        BasePresenter<IAboutView>(mCompositeDisposable), IAboutPresenter {


    override fun init() {
        mCompositeDisposable.add(mAboutInteractor.getUserRepos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {

                }))
    }
}