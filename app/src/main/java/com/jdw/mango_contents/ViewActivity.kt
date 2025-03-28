package com.jdw.mango_contents

import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ViewActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        auth = Firebase.auth
        val database = Firebase.database
        val myRef = database.getReference("bookmark")


        val webView = findViewById<WebView>(R.id.webview)
        val url : String = intent.getStringExtra("url").toString()
        val title : String = intent.getStringExtra("title").toString()
        val imageUrl : String = intent.getStringExtra("imageUrl").toString()

        val btn = findViewById<Button>(R.id.save)

        webView.loadUrl(url)

        btn.setOnClickListener {
            myRef.child(auth.currentUser!!.uid)
                .setValue(ContentsModel(url, imageUrl, title))
        }


    }
}