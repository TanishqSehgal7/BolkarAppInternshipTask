package com.example.bolkarappinternshiptask.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.modelClass.*

class RecyclerView1Adapter(
    context: Context,
    private val persons: ArrayList<Person> =ArrayList()): RecyclerView.Adapter<RecyclerView1Adapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView1Adapter.ViewHolderClass {
        val view = ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview1_item,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: RecyclerView1Adapter.ViewHolderClass, position: Int) {
        val currentPerson = persons[position]
        holder.name.text= currentPerson.n.split(" ")[0]

        if (currentPerson.mod || currentPerson.n=="Prince Tripathi") {
            holder.label.text="Host"
            holder.badge.setImageResource(R.drawable.ic_host_badge)
        } else {
            holder.label.text="Speaker"
            holder.badge.visibility=View.GONE
        }
        if (currentPerson.mic==false) {
            holder.mic.visibility = View.GONE
        } else if (currentPerson.mic==true) {
            holder.mic.visibility = View.VISIBLE
        }

//        personList.add(currentHost.data.host)
//        for (currentPerson in currentHost.data.speakers) {
//            personList.add(currentPerson)
//        }
//        for (currentPerson in currentHost.data.moderators) {
//            personList.add(currentPerson)
//        }
//        holder.name.text = personList[position].n
//        if (personList[position].mod==false) {
//            holder.label.text="Speaker"
//        } else if (personList[position].mod==true && personList[position].n == currentHost.data.host.n) {
//            holder.badge.setImageResource(R.drawable.ic_host_badge)
//        }
//        Log.d("Persons", personList.toString())
    }

    override fun getItemCount(): Int {
        return persons.size;
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.personName)
        val label = itemView.findViewById<TextView>(R.id.personLabel)
        val mic = itemView.findViewById<ImageView>(R.id.mic)
        val badge = itemView.findViewById<ImageView>(R.id.badge)
        val dp = itemView.findViewById<ImageView>(R.id.personDp)
    }

}