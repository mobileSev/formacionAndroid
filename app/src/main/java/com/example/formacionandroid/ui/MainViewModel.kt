package com.example.formacionandroid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel(private val getTeams: GetTeams) : ViewModel() {

    sealed class  ViewState{
        object Loading : ViewState()
        class ShowList(val categorys: List<Team>): ViewState()
        class Error(val error: String): ViewState()
    }


    private  val _state = MutableLiveData<ViewState>()

    val state : LiveData<ViewState>
        get() {
            return _state
        }

    fun getCategory() {

        viewModelScope.launch {
            _state.value = ViewState.Loading
            val res = getTeams.invoke(true)
            res.fold(::handleError, ::handleSuscces)

        }
    }

    private fun handleError(teamError: TeamError) {
        _state.value = ViewState.Error(TeamError.error)
    }

    private fun handleSuscces(list: List<Team>) {
        _state.value =ViewState.ShowList(list)
    }
}