package com.fcom.core.data.di

import com.fcom.core.data.managers.NetworkManager
import com.fcom.core.data.managers.impl.NetworkConnectionMonitor
import com.fcom.core.data.repository.UserDataRepository
import com.fcom.core.data.repository.impl.OfflineUserDataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsUserDataRepository(
        userDataRepository: OfflineUserDataRepository,
    ): UserDataRepository

    @Binds
    internal abstract fun bindsNetworkManager(
        networkMonitor: NetworkConnectionMonitor,
    ): NetworkManager
}