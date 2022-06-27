package com.momentolabs.app.security.applocker.di.module

import com.iammert.hdwallpapers.di.scope.FragmentScope
import com.momentolabs.app.security.applocker.ui.permissiondialog.UsageAccessPermissionDialog
import com.momentolabs.app.security.applocker.ui.policydialog.PrivacyPolicyDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun permissionDialogFragment(): UsageAccessPermissionDialog

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun privacyPolicyDialogFragment(): PrivacyPolicyDialog
}