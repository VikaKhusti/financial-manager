package com.example.financialmanager

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var BALANCE: UserAccount = UserAccount()

    private val PREF_FILE: String = "Account"
    private var PREF_BAL: Int = 0
    var settings: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);

    }


    fun changeBalance (view: View) {
        val context = this
        Log.d("TAG", "clicked")
        Log.d("TAG", "${BALANCE.BALANCE}")


    }


    fun saveBalance (view: View) {

    }
}
