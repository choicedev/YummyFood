package com.choice.features.module

import com.choice.features.navigation.navigator.IYummyNavigator
import com.choice.features.navigation.navigator.YummyNavigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
object NavigatorModule {

    @ViewModelScoped
    @Provides
    fun providesAppNavigator() : YummyNavigator {
        return IYummyNavigator()
    }


}