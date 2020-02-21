package com.example.data.repository

import android.app.Application
import android.util.Log
import com.example.common.Either
import com.example.common.TAG
import com.example.domain.model.Login
import com.example.domain.LoginError
import com.example.domain.LoginRepository

class LoginRepositoryImpl(androidApplication: Application) : LoginRepository {
    override suspend fun doLogin(): Either<LoginError, Login> {
        Log.d(TAG, "TeamRepositoryImpl.getTeam")

        val login =
            ServiceManager.service.doLogin(/*apiKey, regionRepository*/)


        val response: LoginResponse = if (login.isSuccessful) {
            Log.d(TAG, "LoginRepositoryImpl.doLogin.isSuccessful")
            LoginResponse.Success(login.body()?.status)
        } else {
            Log.d(TAG, "LoginRepositoryImpl.doLogin.ERROR")

            LoginResponse.Error("ERROR MESSAGE LOGIN")
        }
        return when (response) {
            is LoginResponse.Success -> Either.Right(
                Login(
                    login.body()?.status
                )
            )
            is LoginResponse.Error -> Either.Left(LoginError("ERROR DE LOGIN"))
        }
    }
}