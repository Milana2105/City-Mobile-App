package com.example.cityinformation.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cityinformation.Adapter2
import com.example.cityinformation.R
import com.example.cityinformation.Response.CityResponse
import com.example.cityinformation.Response.Place3
import com.example.cityinformation.RetrofitIn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CityView : AppCompatActivity(),clcick {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_view)
        val city=intent.getStringExtra("state")
        val cyle=findViewById<RecyclerView>(R.id.myview)
        cyle.layoutManager=GridLayoutManager(this,2)

        CoroutineScope(IO).launch {
            RetrofitIn.instance.getcity(city!!).enqueue(object :Callback<CityResponse>{
                override fun onResponse(
                    call: Call<CityResponse>,
                    response: Response<CityResponse>
                ) {
                    cyle.adapter= Adapter2(this@CityView,response.body()!!.place,this@CityView)
                }

                override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                    Toast.makeText(this@CityView, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    override fun click(g: Place3) {
        val int=Intent(this,StagesActivity::class.java)
        int.putExtra("state",intent.getStringExtra("state"))
        int.putExtra("city",g.city)
        startActivity(int)
    }
}