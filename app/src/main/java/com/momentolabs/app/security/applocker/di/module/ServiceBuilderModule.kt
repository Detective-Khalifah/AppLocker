package com.momentolabs.app.security.applocker.di.module

import com.momentolabs.app.security.applocker.service.AppLockerService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBuilderModule {

    @ContributesAndroidInjector
    abstract fun appLockerService(): AppLockerService
}