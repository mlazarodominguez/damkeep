package com.example.damkeep.ui.auth

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.damkeep.R
import com.example.damkeep.api.response.LoginRequest
import com.example.damkeep.di.MyApp
import javax.inject.Inject


class LoginActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var bLogin: Button
    private lateinit var bRegistro: Button
   @Inject lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        etEmail = findViewById(R.id.loginActivityEmail)
        etPassword = findViewById(R.id.loginActivityPassword)
        bLogin = findViewById(R.id.loginActivityBotonLogIn)
        bRegistro = findViewById(R.id.loginActivityBotonRegistro)
        (applicationContext as MyApp).appComponent.inject(this)


        bLogin.setOnClickListener(View.OnClickListener {
            val req =
                LoginRequest(etEmail.text.toString(), etPassword.text.toString())

            viewModel.login(req)

        })
    }
}


