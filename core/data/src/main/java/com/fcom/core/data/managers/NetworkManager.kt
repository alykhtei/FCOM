package com.fcom.core.data.managers

import kotlinx.coroutines.flow.Flow

interface NetworkManager {
    val isOnline: Flow<Boolean>
}