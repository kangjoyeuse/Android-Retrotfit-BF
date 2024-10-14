package com.kangjoyeuse.submissionbfaa2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kangjoyeuse.submissionbfaa2.R
import com.kangjoyeuse.submissionbfaa2.model.ListEventsItem

class EventAdapter(private val events: List<ListEventsItem>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int = events.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.iv_event)
        private val nameTextView: TextView = itemView.findViewById(R.id.tv_event_name)
        private val dateTextView: TextView = itemView.findViewById(R.id.tv_event_date)

        fun bind(event: ListEventsItem) {
            nameTextView.text = event.name
            dateTextView.text = "${event.dateStart} - ${event.dateFinish}"
            Glide.with(itemView.context)
                .load(event.imageLogo)
                .into(imageView)
        }
    }
}