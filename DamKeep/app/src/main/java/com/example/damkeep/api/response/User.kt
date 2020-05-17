package com.example.damkeep.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class User {
    @SerializedName("createdAt")
    @Expose
    var createdAt: String? = null
    @SerializedName("incidenciasCreadas")
    @Expose
    var id: UUID? = null
    @SerializedName("nombre")
    @Expose
    var nombre: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("rol")
    @Expose
    var rol: String? = null
    @SerializedName("password")
    @Expose
    var password: String? = null
    @SerializedName("avatar")
    @Expose
    var avatar: Any? = null
    @SerializedName("tipoOperario")
    @Expose
    var tipoOperario: String? = null
    @SerializedName("validado")
    @Expose
    var validado: Boolean? = null


}