package com.example.domain

import com.example.common.Either
import com.example.domain.model.Login

interface LoginRepository {
    suspend fun doLogin(): Either<LoginError, Login>

}