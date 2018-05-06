package com.hopeisaprison.ru.moxysample.di.components

import com.hopeisaprison.ru.moxysample.di.modules.GithubModule
import dagger.Component
/**
 * Created by hopeisaprison on 19.02.18.
 */

@Component(modules = [GithubModule::class])
interface GithubComponent {


}