package com.momentolabs.app.security.applocker.di.module

import com.iammert.hdwallpapers.di.scope.FragmentScope
import com.momentolabs.app.security.applocker.ui.permissiondialog.UsageAccessPermissionDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun permissionDialogFragment(): UsageAccessPermissionDialog

}