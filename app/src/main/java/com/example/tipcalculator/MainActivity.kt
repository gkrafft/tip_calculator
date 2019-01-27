package com.example.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    val currencyFormat = NumberFormat.getCurrencyInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ArrayAdapter.createFromResource(this, R.array.percentage, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapter
        val calcButton: Button = findViewById(R.id.calcButton)
        calcButton.setOnClickListener{calcTip()
        }
    }

    private fun calcTip(){
        val billTotal: EditText = findViewById(R.id.totalEntry)
        var total: Double = billTotal.text.toString().toDouble()
        var tip: Double
        var totalTip: Double
        var percent: Double = spinner.selectedItem.toString().toDouble()
        percent /= 100
        tip = total * percent
        totalTip = total + tip

        val tipResult: TextView = findViewById(R.id.textTip)
        val totalResult: TextView = findViewById(R.id.textTotal)

        tipResult.setText("Tip amount: " + currencyFormat.format(tip))
        totalResult.setText("Grand total: " + currencyFormat.format(totalTip))

    }
}
