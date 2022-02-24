package com.example.bolkarappinternshiptask.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.modelClass.Host
import com.example.bolkarappinternshiptask.modelClass.Moderator
import com.example.bolkarappinternshiptask.modelClass.Speaker

class RecyclerView1Adapter (context: Context) : RecyclerView.Adapter<RecyclerView1Adapter.ViewHolderClass>() {

    private var hostList= mutableListOf<Host>()
    private var moderatorList = mutableListOf<Moderator>()
    private var speakerList = mutableListOf<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView1Adapter.ViewHolderClass {
        val view: ViewHolderClass = ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview1_item,parent,false))
        return view
    }

    fun updateHostAfterAnyChangesFromBackEnd(updatedList:List<Host>) {
        hostList = updatedList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateModeratorsAfterAnyChangesFromBackEnd(updatedList:List<Moderator>) {
        moderatorList = updatedList.toMutableList()
        notifyDataSetChanged()
    }

    fun updateSpeakersAfterAnyChangesFromBackEnd(updatedList: List<Speaker>) {
        speakerList = updatedList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView1Adapter.ViewHolderClass, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }


    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.personName)
        val label = itemView.findViewById<TextView>(R.id.personLabel)
        val mic = itemView.findViewById<ImageView>(R.id.mic)
        val badge = itemView.findViewById<ImageView>(R.id.badge)
        val dp = itemView.findViewById<ImageView>(R.id.personDp)
    }

}