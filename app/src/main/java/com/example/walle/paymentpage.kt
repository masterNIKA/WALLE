package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class paymentpage : AppCompatActivity() {

    private lateinit var payButton: TextView
    private lateinit var gotomainpage: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_page)
        init()
        paymentListeners()


    }
    private fun paymentListeners(){
        payButton.setOnClickListener {
            Toast.makeText(this, "Payment Successful", Toast.LENGTH_SHORT).show()
        }

        gotomainpage.setOnClickListener {
            startActivity(Intent(this, mainpage::class.java))
            finish()
        }


    }
    private fun init(){
        payButton = findViewById(R.id.Payment_page_Pay_Button)
        gotomainpage = findViewById(R.id.Payment_Page_Go_To_Main_Page)
    }

}