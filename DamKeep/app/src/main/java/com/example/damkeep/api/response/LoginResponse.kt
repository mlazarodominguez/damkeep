package com.example.damkeep.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginResponse {
    @SerializedName("usuario")
    @Expose
    private var usuario: UserLoginResponse? = null
    @SerializedName("token")
    @Expose
    var token: String? = null

    fun getUsuario(): UserLoginResponse? {
        return usuario
    }

    fun setUsuario(usuario: UserLoginResponse?) {
        this.usuario = usuario
    }

    fun withUsuario(usuario: UserLoginResponse?): LoginResponse {
        this.usuario = usuario
        return this
    }

    fun withToken(token: String?): LoginResponse {
        this.token = token
        return this
    }
}