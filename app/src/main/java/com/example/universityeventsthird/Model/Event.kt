package com.example.universityeventsthird.Model

import com.google.gson.annotations.SerializedName

data class Event(    @SerializedName("course_id")
                     val id: String,
                     @SerializedName("fullname")
                     val title: String,
                     var category: String,
                     var startdate: String,
                     var enddate: String,
                     var description: String,
                     var image: String,
                     var organizers: String)