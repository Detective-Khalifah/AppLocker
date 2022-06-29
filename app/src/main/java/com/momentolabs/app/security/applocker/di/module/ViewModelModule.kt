package com.momentolabs.app.security.applocker.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.momentolabs.app.security.applocker.di.ViewModelFactory
import com.momentolabs.app.security.applocker.di.key.ViewModelKey
import com.momentolabs.app.security.applocker.ui.background.BackgroundsActivityViewModel
import com.momentolabs.app.security.applocker.ui.background.BackgroundsFragmentViewModel
import com.momentolabs.app.security.applocker.ui.intruders.IntrudersPhotosViewModel
import com.momentolabs.app.security.applocker.ui.main.MainViewModel
import com.momentolabs.app.security.applocker.ui.newpattern.CreateNewPatternViewModel
import com.momentolabs.app.security.applocker.ui.overlay.activity.OverlayValidationViewModel
import com.momentolabs.app.security.applocker.ui.permissiondialog.UsageAccessPermissionViewModel
import com.momentolabs.app.security.applocker.ui.permissions.PermissionsViewModel
import com.momentolabs.app.security.applocker.ui.security.SecurityViewModel
import com.momentolabs.app.security.applocker.ui.settings.SettingsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(OverlayValidationViewModel::class)
    abstract fun provideFingerPrintOverlayViewModel(overlayValidationViewModel: OverlayValidationViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(CreateNewPatternViewModel::class)
    abstract fun provideCreateNewPatternViewModel(createNewPatternViewModel: CreateNewPatternViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(PermissionsViewModel::class)
    abstract fun providePermissionsViewModel(permissionsViewModel: PermissionsViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(MainViewModel::class)
    abstract fun provideMainVieWModel(mainViewModel: MainViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(BackgroundsActivityViewModel::class)
    abstract fun provideBackgroundActivityViewModel(backgroundsActivityViewModel: BackgroundsActivityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SecurityViewModel::class)
    abstract fun provideSecurityVieWModel(securityViewModel: SecurityViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(BackgroundsFragmentViewModel::class)
    abstract fun provideBackgroundViewModel(backgroundsFragmentViewModel: BackgroundsFragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SettingsViewModel::class)
    abstract fun provideSettingsViewModel(settingsViewModel: SettingsViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(UsageAccessPermissionViewModel::class)
    abstract fun provideUsageAccessPermissionViewModel(permissionsViewModel: PermissionsViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(IntrudersPhotosViewModel::class)
    abstract fun provideIntrudersPhotosViewModel(intrudersPhotosViewModel: IntrudersPhotosViewModel): ViewModel

    @Binds
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

