package com.example.walle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Add_Card_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_card)

        val cont = findViewById<TextView>(R.id.Add_Card_Add_Button)
        val name = findViewById<EditText>(R.id.Add_Card_Full_Name).text
        val num = findViewById<EditText>(R.id.Add_Card_Card_Number).text
        val cvc = findViewById<EditText>(R.id.Add_Card_CVC).text
        val valid = findViewById<EditText>(R.id.Add_Card_Valid_Thru).text
        val address = findViewById<EditText>(R.id.Add_Card_City).text
        val zip = findViewById<EditText>(R.id.Add_Card_ZIP).text

        cont.setOnClickListener {
            if (name.isEmpty() || num.isEmpty() || cvc.isEmpty() || valid.isEmpty() || address.isEmpty() || zip.isEmpty()){
                Toast.makeText(this,  "ERROR", Toast.LENGTH_LONG)
            }
        }


    }

}