package com.fcom.core.common.network.di

import com.fcom.core.common.network.AppDispatchers
import com.fcom.core.common.network.Dispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(AppDispatchers.IO)
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(AppDispatchers.Default)
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}