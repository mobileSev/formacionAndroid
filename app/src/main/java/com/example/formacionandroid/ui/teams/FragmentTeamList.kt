package com.example.formacionandroid.ui.teams

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.common.TAG
import com.example.formacionandroid.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class FragmentTeamList : Fragment() {

    private val viewModel by viewModel<TeamsViewModel>()
    private lateinit var adapter: TeamListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, null)
        Log.d(TAG, "FragmentTeamList.onCreateView")

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "FragmentTeamList.onViewCreated")

        adapter = TeamListAdapter(/* onClick method here */)
        rvTeamsList?.adapter = adapter
        viewModel.getTeams()
        viewModel.state.observe(this, Observer(::updateList))
    }

    private fun updateList(state: TeamsViewModel.ViewState) {
        Log.d(TAG, "FragmentTeamList.updateList")

        progress.visibility =
            if (state is TeamsViewModel.ViewState.Loading) View.VISIBLE else View.GONE

        when (state) {
            is TeamsViewModel.ViewState.ShowList -> {
                Log.d(TAG, "FragmentTeamList.updateList.ShowList >> ${state.teams}  ")

                adapter.teamList = state.teams
                adapter.notifyDataSetChanged()
            }

            is TeamsViewModel.ViewState.Error -> {
                Log.d(TAG, "FragmentTeamList.updateList.Error")

                AlertDialog.Builder(context)
                    .setMessage(state.error)
                    .setCancelable(true)
                    .create()
                    .show()
            }
        }
    }
}