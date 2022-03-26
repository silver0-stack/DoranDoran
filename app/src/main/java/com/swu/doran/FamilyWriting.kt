package com.swu.doran

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

import org.w3c.dom.Text
import java.util.Currency.getInstance


class FamilyWriting : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var title: String //제목
    private lateinit var content:String //내용

    private var uid:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.family_writing)

        val backBtn = findViewById<ImageButton>(R.id.backBtn)
        val familyUpdateBtn = findViewById<ImageButton>(R.id.family_update_btn)

        val familyTitle = findViewById<EditText>(R.id.family_title)
        val familyContnet = findViewById<EditText>(R.id.family_content)


        backBtn.setOnClickListener{
            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }


        if(intent.hasExtra("uid")){
            uid = intent.getStringExtra("uid").toString()
        }
        familyUpdateBtn.setOnClickListener{
            val database = FirebaseDatabase.getInstance()
            val myRef = database.getReference()

            val dataInput = Family(
                familyTitle.text.toString(),
                familyContnet.text.toString()
            )
            myRef.child("day").child("family").child(uid).push().setValue(dataInput)


            val intent = Intent(this, MainDayActivity::class.java)
            startActivity(intent)
        }




    }
}