package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class createaccount : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var mobileNumber: EditText
    private lateinit var password: EditText
    private lateinit var registerButton: TextView

    private val auth = Firebase.auth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        init()
        createAccountListeners()
    }

    private fun init() {
        fullName = findViewById(R.id.Create_Account_Customer_Name)
        email = findViewById(R.id.Create_Account_Email)
        mobileNumber = findViewById(R.id.Create_Account_Number)
        password = findViewById(R.id.Create_Account_Password)
        registerButton = findViewById(R.id.Create_Account_Register)
    }

    private fun createAccountListeners() {
        registerButton.setOnClickListener {
            val fullName = fullName.text.toString()
            val email = email.text.toString()
            val mobileNumber = mobileNumber.text.toString()
            val password = password.text.toString()
            val numbers = "0123456789"
            val alphabet = "abcdefghijklmnopqrstuvwxyz"

            if (fullName.isEmpty()|| fullName.any { it in numbers }){
                Toast.makeText(this, "Name is empty or contains numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty()){
                Toast.makeText(this, "Input your email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (mobileNumber.isEmpty()|| mobileNumber.any { it in alphabet }){
                Toast.makeText(this, "Number is empty or contains letters",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this,"Now login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this,"something's wrong",Toast.LENGTH_SHORT).show()
                }
            }
        }




    }
}