package com.example.formacionandroid.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.TeamError
import com.example.domain.useCases.DoLogin
import androidx.lifecycle.viewModelScope
import com.example.domain.Login
import com.example.domain.LoginError
import kotlinx.coroutines.launch

class LoginViewModel(private val doLogin: DoLogin) : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        object Login: ViewState()
        class Error(val error: String): ViewState()
    }


    private  val _state = MutableLiveData<ViewState>()

    val state : LiveData<ViewState>
        get() {
            return _state
        }

    fun doLogIn() {
        viewModelScope.launch {
            _state.value = ViewState.Loading
            val res = doLogin.invoke()
            res.fold(::handleError, ::handleSuccces)
        }
    }

    private fun handleError(teamError: LoginError) {
        _state.value = ViewState.Error(teamError.error)
    }

    private fun handleSuccces(login: Login) {
        _state.value = ViewState.Login
    }
}