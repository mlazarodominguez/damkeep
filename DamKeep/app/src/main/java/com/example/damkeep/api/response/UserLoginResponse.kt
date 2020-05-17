package com.example.damkeep.api.response

data class UserLoginResponse(
    val fullName: String,
    val id: String,
    val roles: String,
    val username: String
)