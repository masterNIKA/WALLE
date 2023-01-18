package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class newpassword : AppCompatActivity() {

    private lateinit var oldPassword: EditText
    private lateinit var newPassword: EditText
    private lateinit var continueButton: TextView
    private val auth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_password)
        init()
        createNewPasswordListeners()
    }

    private fun init(){
        oldPassword = findViewById(R.id.New_Password_Enter_Your_Password)
        newPassword = findViewById(R.id.New_Password_Create_New_Password)
        continueButton = findViewById(R.id.New_Password_Continue_Button)
    }

    private fun createNewPasswordListeners(){
        continueButton.setOnClickListener {
            val oldPassword = oldPassword.text.toString()
            val newPassword = newPassword.text.toString()

            if(newPassword==oldPassword){
                Toast.makeText(this, "Try another password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (newPassword.isEmpty()){
                Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.currentUser?.updatePassword(newPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Your password changed", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "something's wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}