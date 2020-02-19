package com.example.formacionandroid.ui.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.Team
import com.example.domain.TeamError
import com.example.domain.useCases.DoLogin
import com.example.domain.useCases.GetTeam
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TeamsViewModel(
    private val getTeams: GetTeam
) : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val teams: List<Team>): ViewState()
        class Error(val error: String): ViewState()
    }


    private  val _state = MutableLiveData<ViewState>()

    val state : LiveData<ViewState>
        get() {
            return _state
        }

    fun getTeams() {
        viewModelScope.launch {
            _state.value = ViewState.Loading
            val res = getTeams.invoke()
            res.fold(::handleError, ::handleSuscces)

        }
    }

    private fun handleError(teamError: TeamError) {
        _state.value = ViewState.Error(teamError.error)
    }

    private fun handleSuscces(list: List<Team>) {
        _state.value = ViewState.ShowList(list)
    }
}