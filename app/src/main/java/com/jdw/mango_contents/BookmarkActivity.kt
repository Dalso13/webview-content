package com.jdw.mango_contents

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val list = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        auth = Firebase.auth
        val database = Firebase.database
        val myRef = database.getReference("bookmark")

        val rv = findViewById<RecyclerView>(R.id.bookmarkRV)
        val rvAdapter = RVAdapter(list,baseContext)
        rv.adapter = rvAdapter

        rvAdapter.itemClick = object: RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url", list[position].url)
                intent.putExtra("title", list[position].title)
                intent.putExtra("imageUrl", list[position].imageUrl)
                startActivity(intent)
            }

        }

        rv.layoutManager = GridLayoutManager(this,2)

        // db 데이터 가져오기
        myRef.child(auth.currentUser!!.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                   for (dataModel in snapshot.children) {
                       val obj = dataModel.value as Map<*, *>
                       list.add(
                           ContentsModel(
                               obj["imageUrl"].toString(),
                               obj["title"].toString(),
                               obj["url"].toString()
                           )
                       )
                   }
                    rvAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("bookmark", "db error")
                }

            })
    }


}