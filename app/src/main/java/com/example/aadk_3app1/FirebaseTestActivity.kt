package com.example.aadk_3app1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.aadk_3app1.databinding.ActivityFirebaseTestBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID

class FirebaseTestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirebaseTestBinding
    private lateinit var mFirebaseDatabase: FirebaseDatabase
    private lateinit var mFirebaseStorage: FirebaseStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirebaseTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Add firebase storage
        mFirebaseStorage = FirebaseStorage.getInstance()

        // Select an image
        binding.selectBtn.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_PICK
            startActivityForResult(
                Intent.createChooser(intent, "Select an Image"),
                123
            )
        }
        // Set this image to the ImageView -- onActivityResult() method

        // Upload it on firebase

        // Add data in Firebase
//        mFirebaseDatabase = FirebaseDatabase.getInstance("https://aadk-3-app1-default-rtdb.asia-southeast1.firebasedatabase.app/")
//        val reference = mFirebaseDatabase.reference
//
//        val userReference = reference.child("Users")
//        val bookRef = reference.child("Books")
//        bookRef.child(UUID.randomUUID().toString()).setValue("Angels and Demons")

//        binding.btn.setOnClickListener {
//            val firstName = binding.et1.text.toString()
//            val lastName = binding.et2.text.toString()
//
//            userReference.child(UUID.randomUUID().toString()).setValue("$firstName $lastName")
//            binding.et1.text.clear()
//            binding.et2.text.clear()
//        }

        // Fetch this data from Firebase
//        val listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                Log.d("wieufwoe", "DB updated")
//                var str = ""
//                snapshot.children.forEach {
//                    str += "${it.key} - ${it.value}\n"
//                }
//                binding.tv.text = str
//            }
//
//            override fun onCancelled(error: DatabaseError) { }
//        }
        // search.onClick {
//        userReference.addValueEventListener(listener)
        //}

        // once the search is done
//        userReference.removeEventListener(listener)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == RESULT_OK) {
            if (data != null && data.data != null) {
                val filePath = data.data
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                binding.ivSelectedImage.setImageBitmap(bitmap)

                binding.btn.setOnClickListener {
                    val reference = mFirebaseStorage.reference
                    val imageReference = reference.child("images")
                    imageReference.child(UUID.randomUUID().toString()).putFile(filePath!!)
                        .addOnSuccessListener {
                            Log.d("ajwbdlw", "Upload Successful")

                        }
                        .addOnFailureListener {
                            Log.d("qebfebu", "${it.message}")
                        }
                }
            }
        }
    }
}
/*
* Ref -> Top level of your db
* ref.child("users"), checks if there is a user as a child in the database or not
* if not, it creates one and returns reference of this level now
* after that on button click
* fetching the details and pushing it into the db like this userRef.child(fn).setValue(ln)
* this creates a key value pair in Users (because we are adding them in the usrRef)
* */
