package com.example.financialmanager

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var account: UserAccount = UserAccount(0, 0)

    private val PREF_FILE: String = "Account"
    private var PREF_BAL: Int = 0
    var settings: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings = getSharedPreferences(PREF_FILE, MODE_PRIVATE);

        progressBar.progress = (account.income / account.balance * 10)
    }


    fun changeBalance (view: View) {
        val context = this
        Log.d("TAG", "")

        val bal: Int = (account.balance / account.income) * 100

        Log.d("TAG", "${account.income / account.balance * 10}")


        val intent = Intent(this, BalanceInfoActivity::class.java)
        startActivity(intent)
    }


    fun saveBalance (view: View) {

    }
}
