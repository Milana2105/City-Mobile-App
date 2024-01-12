package com.example.cityinformation.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.cityinformation.R

class StagesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stages)
        val state=intent.getStringExtra("state")
        val city=intent.getStringExtra("city")
        val int=Intent(this,LastActivity::class.java )
        int.putExtra("state",state)
        int.putExtra("city",city)
        findViewById<ImageView>(R.id.tor).setOnClickListener {
      int.putExtra("catgory","Tourist Places")
            startActivity(int)
        }
        findViewById<ImageView>(R.id.hotels).setOnClickListener {
            int.putExtra("catgory","Hotels")
            startActivity(int)
        }
        findViewById<ImageView>(R.id.busstans).setOnClickListener {
            int.putExtra("catgory","Bus Stands")
            startActivity(int)
        }
        findViewById<ImageView>(R.id.hospitals).setOnClickListener {
            int.putExtra("catgory","Hospitals")
            startActivity(int)
        }



    }
}