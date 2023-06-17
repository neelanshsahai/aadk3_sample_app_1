package com.example.aadk_3app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aadk_3app1.databinding.ActivityListBinding

class ListActivity : AppCompatActivity(), MyItemClickListener {

    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val integers = (1..25).toList()
//
//        val myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, integers)
//        binding.myListView.adapter = myAdapter

        // This is a click event on the entire list
//        binding.myListView.setOnClickListener {
//            Log.d("lqiuefquew", "Item Clicked")
//        }

        // We need a click event for one particular element of the list
//        binding.myListView.setOnItemClickListener { parent, view, position, id ->
//            Log.d("udyxuc", "Element $position was clicked")
//        }

        val users = listOf(
            User("Rohit", "Saini", "123"),
            User("Niranjan", "V", "234"),
            User("Aayan", "Shukla", "345"),
            User("Pratyansh", "M", "456"),
            User("Prem", "Kumar", "567"),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
            User(),
        )

        // Setting a Layout Manager for the RV
        binding.myRecyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        // Setting an Adapter for the RV
        binding.myRecyclerView.adapter = MyAdapter(users, this)
    }

    override fun onItemClicked(user: User) {
        Log.d("agdqwiwu", user.toString())
    }

    override fun onProfilePicClicked(user: User) {
        Log.d("kdebfoine", "View Profile Pic")
    }
}

data class User(
    val firstname: String = "ABC",
    val lastname: String = "MNO",
    val contact: String = "XYZ"
)
