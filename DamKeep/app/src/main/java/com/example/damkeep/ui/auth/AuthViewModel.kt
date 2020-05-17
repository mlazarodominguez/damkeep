package com.example.damkeep.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.damkeep.api.response.LoginRequest
import com.example.damkeep.api.response.LoginResponse
import com.example.damkeep.repository.AuthRepository
import javax.inject.Inject

class AuthViewModel  @Inject constructor(
    authRepository: AuthRepository
): ViewModel() {
        var repository =  authRepository
        lateinit var loginReponse: LiveData<LoginResponse>

    fun login(loginRequest: LoginRequest): LiveData<LoginResponse> {
        loginReponse =  repository.login(loginRequest)
        return loginReponse
    }
}