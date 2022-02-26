package com.example.bolkarappinternshiptask.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.view.MainActivity

class RecyclerView1Adapter(
    private var persons: ArrayList<Person> =ArrayList(),
    private val imageUrlList:ArrayList<String> = ArrayList(),
    val activity:MainActivity
): RecyclerView.Adapter<RecyclerView1Adapter.ViewHolderClass>() {

    val personList = this.persons
    val urlList = this.imageUrlList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view = ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview1_item,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {

        val currentPerson = personList[position]
        Log.d("Adapter 1", currentPerson.toString())
        holder.name.text= currentPerson.n.split(" ")[0]

        Glide.with(activity).load(urlList[position]).into(holder.dp)

        if (currentPerson.mod || currentPerson.n=="Prince Tripathi") {
            holder.label.text= activity.getString(R.string.HostString)
            holder.badge.setImageResource(R.drawable.ic_host_badge)
            if (currentPerson.n=="Prince tripathi") {

            }
        } else {
            holder.label.text= activity.getString(R.string.SpeakerString)
            holder.badge.visibility=View.GONE
            holder.mic.visibility=View.VISIBLE
        }
        if (currentPerson.mic==true) {
            holder.mic.visibility = View.GONE
        } else if (currentPerson.mic==false) {
            holder.mic.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return personList.size;
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.personName)
        val label = itemView.findViewById<TextView>(R.id.personLabel)
        val mic = itemView.findViewById<ImageView>(R.id.mic)
        val badge = itemView.findViewById<ImageView>(R.id.badge)
        val dp = itemView.findViewById<ImageView>(R.id.personDp)
    }

}