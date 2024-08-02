package com.example.firstcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.MainActivityUIState.Loading
import com.example.firstcompose.MainActivityUIState.Success
import com.fcom.core.data.model.ui.UserData
import com.fcom.core.data.repository.UserDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    userDataRepository: UserDataRepository
) : ViewModel() {

    val uiState: StateFlow<MainActivityUIState> = userDataRepository.userData.map { Success(it) }
        .stateIn(
            scope = viewModelScope,
            initialValue = Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}

sealed interface MainActivityUIState {
    data object Loading : MainActivityUIState
    data class Success(val userData: UserData) : MainActivityUIState
}