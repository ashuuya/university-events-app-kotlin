package com.example.universityeventsthird
import Common
import RetrofitServices
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.universityeventsthird.Adapter.EventAdapter
import com.example.universityeventsthird.Model.Event
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: EventAdapter
    lateinit var rv: RecyclerView
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        layoutManager = LinearLayoutManager(this)
        rv = findViewById(R.id.rv)
        rv.layoutManager = layoutManager
        progressBar = findViewById(R.id.progressBar)

        getAllEvents()
    }

    private fun getAllEvents() {
        mService.getAllEvents().enqueue(object : Callback<MutableList<Event>> {
            override fun onFailure(call: Call<MutableList<Event>>, t: Throwable) {
                progressBar.visibility = View.INVISIBLE
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<MutableList<Event>>, response: Response<MutableList<Event>>) {
                progressBar.visibility = View.INVISIBLE
                adapter = EventAdapter(baseContext, response.body() as MutableList<Event>)
                adapter.notifyDataSetChanged()
                rv.adapter = adapter
            }
        })
    }
}