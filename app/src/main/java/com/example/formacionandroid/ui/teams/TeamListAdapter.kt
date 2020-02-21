package com.example.formacionandroid.ui.teams

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.common.TAG
import com.example.domain.model.Team
import com.example.formacionandroid.R
import kotlinx.android.synthetic.main.item_team.view.*

class TeamListAdapter : RecyclerView.Adapter<TeamListAdapter.TeamHolder>() {

    var teamList: List<Team>? = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        Log.d(TAG, "TeamListAdapter.onCreateViewHolder")

        return TeamHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        )
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "TeamListAdapter.getItemCount")

        val size = teamList?.size
        return if (size != null) size else 0
    }

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        Log.d(TAG, "TeamListAdapter.onBindViewHolder >>  ${teamList?.get(position)}")

        holder.bind(teamList?.get(position))
    }

    class TeamHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(team: Team?) = with(itemView) {
            Log.d(TAG, "TeamHolder.bind")

            tvTeamName.text = team?.fullName
            ivTeamIcon.load(team?.logo)
        }
    }
}