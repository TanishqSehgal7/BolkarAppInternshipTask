package com.example.bolkarappinternshiptask.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R

class RecyclerView1Adapter (context: Context) : RecyclerView.Adapter<RecyclerView1Adapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView1Adapter.ViewHolderClass {
        val view: ViewHolderClass = ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview1_item,parent,false))

        return view
    }


    override fun onBindViewHolder(holder: RecyclerView1Adapter.ViewHolderClass, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }


    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {



    }

}