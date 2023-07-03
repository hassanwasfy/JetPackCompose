package com.example.jetpackcompose.screens.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel  @Inject constructor() :ViewModel() {
    private val _state = MutableStateFlow(ProfileUiState())
    val state = _state.asStateFlow()


    fun onChangeFirstName(newValue: String){
        _state.update { it.copy(firstName = newValue) }
    }

    fun onChangeLastName(newValue: String){
        _state.update { it.copy(secondName = newValue) }
    }

    fun onChangeEmail(newValue: String){
        _state.update { it.copy(email = newValue) }
    }

    fun onChangeGender(newValue: String){
        _state.update { it.copy(gender = newValue) }
    }

    fun onChangeMobile(newValue: String){
        _state.update { it.copy(mobile = newValue) }
    }

    fun onChangeLocation(newValue: String){
        _state.update { it.copy(location = newValue) }
    }

    fun saveUserInformation(){

    }
}