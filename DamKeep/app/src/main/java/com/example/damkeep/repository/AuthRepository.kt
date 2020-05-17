package com.example.damkeep.repository

import android.content.Intent
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.example.damkeep.MainActivity
import com.example.damkeep.api.ApiService
import com.example.damkeep.api.response.LoginRequest
import com.example.damkeep.api.response.LoginResponse
import com.example.damkeep.common.Constants
import com.example.damkeep.di.MyApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

//TODO para instanciar TheMovieDBRepository, debemos indicar que depende de TheMovieDBService

@Singleton
class AuthRepository @Inject constructor(var apiService: ApiService) {
    var loginResponse: MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()


    fun login(loginRequest:LoginRequest): MutableLiveData<LoginResponse> {

        val call: Call<LoginResponse> = apiService.login(loginRequest)
        call?.enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                Toast.makeText(MyApp.instance, "Usuario o Contraseña incorrecto", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if(response.isSuccessful) {
                    loginResponse.value = response.body()
                    Constants.TOKEN = response.body()?.token.toString()
                    val intent = Intent(MyApp.instance, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;

                    ContextCompat.startActivity(MyApp.instance, intent, null)

                }
            }
        })

        return loginResponse
    }

}