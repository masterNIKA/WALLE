package com.example.walle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class Add_Card_Activity : AppCompatActivity() {

    private lateinit var fullName: EditText
    private lateinit var cardNumber: EditText
    private lateinit var cvc: EditText
    private lateinit var validThru: EditText
    private lateinit var userAddress: EditText
    private lateinit var cardName: EditText
    private lateinit var addButton: TextView

    private val db = FirebaseDatabase.getInstance().getReference("userinfo")
    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)
        init()
        addCardListeners()
    }

    private fun init(){
        fullName = findViewById(R.id.Add_Card_Full_Name)
        cardNumber = findViewById(R.id.Add_Card_Card_Number)
        cvc = findViewById(R.id.Add_Card_CVC)
        validThru = findViewById(R.id.Add_Card_Valid_Thru)
        userAddress = findViewById(R.id.Add_Card_City)
        cardName = findViewById(R.id.Add_Card_Card_Name)
        addButton = findViewById(R.id.Add_Card_Add_Button)
    }

    private fun addCardListeners() {
        addButton.setOnClickListener {
            val fullName = fullName.text.toString()
            val cardName = cardName.text.toString()
            val cvc = cvc.text.toString()
            val validThru = validThru.text.toString()
            val userAddress = userAddress.text.toString()
            val cardNumber = cardNumber.text.toString()
            val addButton = addButton.text.toString()
            val nameSymbols = "0123456789"
            val cardNameSymbols = "abcdefghijklmnopqrstuvwxyz"

            if (fullName.isEmpty() || fullName.any {it in nameSymbols}){
                Toast.makeText(this, "Name is empty or contains numbers",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cardName.isEmpty() || cardName.any {it in cardNameSymbols}){
                Toast.makeText(this, "Card name is empty or contains letters",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cvc.isEmpty() || cvc.any {it in cardNameSymbols}){
                Toast.makeText(this, "CVC is empty or contains letters",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cvc.length > 4){
                Toast.makeText(this, "Too many numbers",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (validThru.isEmpty() || validThru.length != 4){
                Toast.makeText(this, "Date is empty or incorrect",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (userAddress.isEmpty()){
                Toast.makeText(this, "Input your address",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (cardNumber.isEmpty() || cardNumber.any {it in cardNameSymbols}){
                Toast.makeText(this, "Card Number is empty or contains letters",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{

            }


        }
    }
}

