package com.example.domain

import com.example.common.Either

interface LoginRepository {
    suspend fun doLogin(): Either<LoginError, Login>

}