package com.example.firebase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivity : AppCompatActivity() {
//    private  lateinit var mUsers : MutableList<User>
//    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var email = findViewById<TextView>(R.id.email)
        var fullname = findViewById<TextView>(R.id.fullname)

//         Write a message to the database
//        val database = FirebaseDatabase.getInstance()
//        val myRef = database.getReference("message").child("child1").child("child2")
//
//        myRef.setValue("Hello, Child!")

//        mUsers = mutableListOf()
//        userAdapter = UserAdapter()
//        userAdapter.mUsers = mUsers

        var data2 =
                FirebaseDatabase.getInstance().getReference().child("Topics").child("userId")
                        .child("Child1")
//        var hashMap = HashMap<String, String>()
//        hashMap.put("email", "stefanusdany@gmail.com")
//        hashMap.put("fullname", "stefanus dany")

//        reference.setValue(hashMap)

        var data1 = FirebaseDatabase.getInstance().getReference().child("Topics").child("userId")
                .child("Child")

        // Read from the database
        data1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue(User::class.java)
                email.text = value?.email
                fullname.text = value?.fullname

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
    }
}