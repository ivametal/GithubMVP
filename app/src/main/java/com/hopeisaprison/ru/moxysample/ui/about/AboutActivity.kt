package com.hopeisaprison.ru.moxysample.ui.about

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.hopeisaprison.ru.moxysample.R
import com.hopeisaprison.ru.moxysample.data.network.model.Repository
import com.hopeisaprison.ru.moxysample.ui.base.BaseActivity
import com.hopeisaprison.ru.moxysample.ui.signin.SignInPresenter
import javax.inject.Inject

/**
 * Created by hopeisaprison on 18.03.18.
 */
class AboutActivity : BaseActivity(), IAboutView {


    @Inject
    lateinit var mDaggerPresenter: AboutPresenter
        @ProvidePresenter get

    @InjectPresenter
    lateinit var mAboutPresenter : AboutPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        mActivityComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)


        mAboutPresenter.init()
    }

    override fun showUserRepos(reposList: List<Repository>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}