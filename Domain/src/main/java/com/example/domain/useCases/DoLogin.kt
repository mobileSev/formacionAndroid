package com.example.domain.useCases

import com.example.common.Either
import com.example.domain.Login
import com.example.domain.LoginError
import com.example.domain.LoginRepository

class DoLogin(private val repository: LoginRepository) {
    suspend fun invoke(): Either<LoginError, Login> = repository.doLogin()

}