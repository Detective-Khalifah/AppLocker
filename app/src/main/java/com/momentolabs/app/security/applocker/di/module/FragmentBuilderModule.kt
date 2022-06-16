package com.momentolabs.app.security.applocker.di.module

import com.iammert.hdwallpapers.di.scope.FragmentScope
import com.momentolabs.app.security.applocker.ui.background.BackgroundsFragment
import com.momentolabs.app.security.applocker.ui.security.SecurityFragment
import com.momentolabs.app.security.applocker.ui.settings.SettingsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun securityFragment(): SecurityFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun backgroundFragment(): BackgroundsFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun settingsFragment(): SettingsFragment
}