package com.example.jetpackcompose.screens.login

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() :ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state = _state.asStateFlow()

    fun onChangeUsername(newValue: String){
        _state.update { it.copy(userName = newValue) }
    }

    fun onChangePassword(newValue: String){
        _state.update { it.copy(password = newValue) }
    }

    fun onForgetPassword(){
        Log.i("H010H","Change Password")
    }

    fun onLogin(){
        Log.i("H010H","Goto Login Page")
    }


}