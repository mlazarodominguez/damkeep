package com.example.damkeep.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RegisterReponse {
    @SerializedName("user")
    @Expose
    var user: User? = null
    @SerializedName("token")
    @Expose
    var token: String? = null

}