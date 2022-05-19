package com.example.universityeventsthird.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.universityeventsthird.Model.Event
import com.example.universityeventsthird.R

class EventAdapter(private val context: Context, private val eventList: MutableList<Event>):RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title: TextView = itemView.findViewById(R.id.title)
        //val category: TextView = itemView.findViewById(R.id.)
        val startdate: TextView = itemView.findViewById(R.id.dateEvent)
        val enddate: TextView = itemView.findViewById(R.id.isAvailable)
        val description: TextView = itemView.findViewById(R.id.descText)
        //val image: TextView = itemView.findViewById(R.id.)
        val organizers: TextView = itemView.findViewById(R.id.orgText)

        fun bind(listItem: Event) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = eventList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = eventList[position]
        holder.bind(listItem)

//        Picasso.get().load(eventList[position].imageurl).into(holder.image)
        holder.title.text = eventList[position].title
        holder.description.text = eventList[position].description
        holder.enddate.text = eventList[position].enddate
        holder.startdate.text = eventList[position].startdate
        holder.organizers.text = eventList[position].organizers
    }

}