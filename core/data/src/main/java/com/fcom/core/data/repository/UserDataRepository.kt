package com.fcom.core.data.repository

import com.fcom.core.data.model.ui.UserData
import kotlinx.coroutines.flow.Flow


interface UserDataRepository {

    val userData: Flow<UserData>

    suspend fun getUserData(): UserData
}