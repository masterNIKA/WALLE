package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_Payment_Successful : AppCompatActivity() {

    private lateinit var goToMainPage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_successful)
        init()
        paymentSuccessful()


    }
    private fun paymentSuccessful(){
        goToMainPage.setOnClickListener {
            startActivity(Intent(this,mainpage::class.java))
            finish()
        }

    }
    private fun init(){

        goToMainPage = findViewById(R.id.Pay_Success_Go_To_Main_Page)
    }
}