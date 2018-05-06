package com.hopeisaprison.ru.moxysample.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by hopeisaprison on 04.03.18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerActivity
