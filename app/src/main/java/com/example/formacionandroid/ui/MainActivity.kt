package com.example.formacionandroid.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.formacionandroid.R
import com.example.formacionandroid.ui.teams.FragmentTeamList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(com.example.common.TAG, "MainActivity.onCreate")

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.clMainContainer, FragmentTeamList())
        transaction.commit()
    }
}
