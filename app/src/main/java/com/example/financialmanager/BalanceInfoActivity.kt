package com.example.financialmanager

import android.R.attr.name
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_balance_info.*


class BalanceInfoActivity : AppCompatActivity() {

    var account: UserAccount = UserAccount(0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balance_info)

        settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);

        account.income = settings?.getString(PREF_NAME, account.income.toString())?.toInt()!!

        progressBar2.progress = (account.income!!.toInt() / account.balance * 10)
        balanceInfoTextView.text = progressBar2.progress.toString() + "%"

        balanceTextView.text = account.balance.toString()
        incomeTextView.text = account.income.toString()



    }

    var newValue: String = account.income.toString()

    private val PREFS_FILE: String = "Account"
    private var PREF_NAME: String = "Income"
    var settings: SharedPreferences? = null

    fun editPrefs(view: View) {

        Log.d("TAG", "${settings?.getString(PREF_NAME, account.income.toString())}")

        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Change your montly income")

        val input: EditText = EditText(this)
        input.setRawInputType(InputType.TYPE_CLASS_NUMBER)

        dialogBuilder.setView(input)

        dialogBuilder.setPositiveButton("OK"){dialogInterface, which ->
            newValue = input.text.toString()
            account.income = newValue.toInt()
            Toast.makeText(applicationContext,"Value was edited to $newValue",Toast.LENGTH_LONG).show()

        }

        dialogBuilder.setNegativeButton("Cancel"){dialogInterface, which ->
            //Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
        }

        val prefEditor = settings!!.edit()
        prefEditor.putString(PREF_NAME, newValue)
        prefEditor.apply()

        getValue()

        dialogBuilder.show()
    }

    fun getValue() {

       // val getVal: String? = settings?.getString(PREF_NAME,"не определено")
        account.income = settings?.getString(PREF_NAME, account.income.toString())?.toInt()!!

        progressBar2.progress = account.income / account.balance * 10
        balanceInfoTextView.text = progressBar2.progress.toString() + "%"

        balanceTextView.text = account.balance.toString()
        incomeTextView.text = account.income.toString()
    }


}
