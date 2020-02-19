package com.example.formacionandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.formacionandroid.R
import com.example.formacionandroid.ui.teams.FragmentTeamList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.clMainContainer, FragmentTeamList())
        transaction.commit()
    }
}
