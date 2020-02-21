package com.example.formacionandroid.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.TAG
import com.example.domain.TeamError
import com.example.domain.model.Team
import com.example.domain.useCases.DoLogin
import com.example.domain.useCases.GetTeam
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getTeams: GetTeam,
    private val doLogin: DoLogin
) : ViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        class ShowList(val teams: List<Team>?) : ViewState()
        class Error(val error: String) : ViewState()
    }


    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() {
            Log.d(TAG, "ViewState.state.get")

            return _state
        }

    fun doLogIn() {
        Log.d(TAG, "ViewState.doLogIn")

        viewModelScope.launch {
            _state.value =
                ViewState.Loading
            val res = getTeams.invoke()
            res.fold(::handleError, ::handleSuscces)

        }
    }

    fun getTeams() {
        Log.d(TAG, "ViewState.getTeams")

        viewModelScope.launch {
            _state.value =
                ViewState.Loading
            val res = getTeams.invoke()
            res.fold(::handleError, ::handleSuscces)

        }
    }

    private fun handleError(teamError: TeamError) {
        Log.d(TAG, "ViewState.handleError")

        _state.value =
            ViewState.Error(
                teamError.error
            )
    }

    private fun handleSuscces(list: List<Team>?) {
        Log.d(TAG, "ViewState.handleSuscces")

        _state.value =
            ViewState.ShowList(
                list
            )
    }
}