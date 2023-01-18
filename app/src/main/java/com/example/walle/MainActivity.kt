package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var forgotpassword: TextView
    private lateinit var loginbutton: TextView
    private lateinit var signup: TextView
    private val firebaseAuth = Firebase.auth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        loginlisteners()


    }

    private fun init(){
        email = findViewById(R.id.Log_Pg_Customer_Email)
        password = findViewById(R.id.Log_Pg_Pass)
        forgotpassword = findViewById(R.id.Log_Pg_Forgot_Password)
        loginbutton = findViewById(R.id.Log_Pg_Log_In_Button)
        signup = findViewById(R.id.Log_Pg_Sign_Up)
    }

    private fun loginlisteners() {

        email.setOnClickListener {
            email.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        }

        loginbutton.setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,  "email or password is empty" , Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
                if (task.isSuccessful){
                    startActivity(Intent(this,mainpage::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Don't have an account? Sign Up", Toast.LENGTH_SHORT).show()
                }

            }
        }

        forgotpassword.setOnClickListener {
            startActivity(Intent(this,emailverification::class.java))
            finish()
        }

        signup.setOnClickListener {
            startActivity(Intent(this,createaccount::class.java))
            finish()
        }
    }
}