package com.fcom.core.data.repository.impl

import com.fcom.core.data.model.ui.UserData
import com.fcom.core.data.repository.UserDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class OfflineUserDataRepository @Inject constructor() : UserDataRepository {

    override val userData: Flow<UserData> = flow { UserData(true) }
}