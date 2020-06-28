package com.example.financialmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_presets.*

class PresetsActivity : AppCompatActivity() {

    var balance: Int = 0
    var income: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presets)

        textView2.text = "Hello, I am your Financial Manager."
        textView5.text = "Before we start, I need to do some presets"
        textView6.text = "Here type amount, that left in your purse now"
        textView7.text = "Here type your monthly income"
    }

    fun start(view: View) {
        balance = Integer.parseInt(balanceEditText.text.toString())
        income = Integer.parseInt(incomeEditText.text.toString())

        var account: UserAccount = UserAccount(balance, income)
        Log.d("TAG", "${account.balance} + ${account.income}")
    }

}
