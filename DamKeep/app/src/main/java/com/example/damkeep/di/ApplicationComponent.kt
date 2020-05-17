package com.example.damkeep.di


import com.example.damkeep.api.NetworkModule
import com.example.damkeep.ui.auth.AuthViewModel
import com.example.damkeep.ui.auth.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component( modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(loginActivity: LoginActivity)

}