package com.example.formacionandroid.ui.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.formacionandroid.R
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentTeamList: Fragment() {

    private lateinit var viewModel: TeamsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[TeamsViewModel::class.java]
        rvTeamsList?.adapter = TeamListAdapter()


    }
}