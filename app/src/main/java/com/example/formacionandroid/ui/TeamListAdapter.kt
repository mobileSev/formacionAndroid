package com.example.formacionandroid.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.example.formacionandroid.R
import kotlinx.android.synthetic.main.item_team.view.*

class TeamListAdapter : RecyclerView.Adapter<TeamListAdapter.TeamHolder>() {
    
    var teamList: List<Team> = emptyList()
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder {
        return TeamHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false))
    }

    override fun getItemCount(): Int = teamList.size

    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList[position])
    }

    class TeamHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {
        fun bind(team: Team) = with(itemView) {
            tvTeamName.text = team.name
            ivTeamIcon.load(team.logo)
        }
    }
}