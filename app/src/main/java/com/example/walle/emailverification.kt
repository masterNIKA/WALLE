package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class emailverification : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var sendButton: TextView
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_verification)
        init()
        emailVerificationListeners()
    }

    private fun init(){
        emailInput = findViewById(R.id.Fg_Pass_Email)
        sendButton = findViewById(R.id.Fg_Pass_Email_Send_Button)
    }

    private fun emailVerificationListeners(){
        sendButton.setOnClickListener {
            val email = emailInput.text.toString()

            if (email.isEmpty()){
                return@setOnClickListener
            }

            auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this,"Check your email",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,newpassword::class.java))
                } else {
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}