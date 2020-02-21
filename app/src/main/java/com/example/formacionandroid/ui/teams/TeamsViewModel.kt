package com.example.formacionandroid.ui.teams

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.TAG
import com.example.domain.TeamError
import com.example.domain.model.Team
import com.example.domain.useCases.GetTeam
import kotlinx.coroutines.launch

class TeamsViewModel(
    private val getTeams: GetTeam
) : ViewModel() {

    sealed class ViewState {
        object Loading : ViewState()
        class ShowList(val teams: List<Team>?) : ViewState()
        class Error(val error: String) : ViewState()
    }


    private val _state = MutableLiveData<ViewState>()

    val state: LiveData<ViewState>
        get() {
            return _state
        }

    fun getTeams() {
        Log.d(TAG, "TeamsViewModel.getTeams")

        viewModelScope.launch {
            _state.value = ViewState.Loading
            val res = getTeams.invoke()
            res.fold(::handleError, ::handleSuscces)

        }
    }

    private fun handleError(teamError: TeamError) {
        Log.d(TAG, "TeamsViewModel.handleError")

        _state.value = ViewState.Error(teamError.error)
    }

    private fun handleSuscces(list: List<Team>?) {
        Log.d(TAG, "TeamsViewModel.handleSuscces $list")

        _state.value = ViewState.ShowList(list)
    }
}