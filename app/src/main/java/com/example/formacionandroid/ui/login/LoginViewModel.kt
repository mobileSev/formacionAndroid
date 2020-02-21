package com.example.formacionandroid.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.TAG
import com.example.domain.LoginError
import com.example.domain.model.Login
import com.example.domain.useCases.DoLogin
import kotlinx.coroutines.launch

class LoginViewModel(private val doLogin: DoLogin) : ViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        object Login : ViewState()
        class Error(val error: String) : ViewState()
    }


    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() {
            Log.d(TAG, "LoginViewModel.state.get")

            return _state
        }

    fun doLogIn() {
        Log.d(TAG, "LoginViewModel.doLogIn")

        viewModelScope.launch {
            _state.value = ViewState.Loading
            val res = doLogin.invoke()
            res.fold(::handleError, ::handleSuccces)
        }
    }

    private fun handleError(teamError: LoginError) {
        Log.d(TAG, "LoginViewModel.handleError")

        _state.value = ViewState.Error(teamError.error)
    }

    private fun handleSuccces(login: Login) {
        Log.d(TAG, "LoginViewModel.handleSuccces")

        _state.value = ViewState.Login
    }
}