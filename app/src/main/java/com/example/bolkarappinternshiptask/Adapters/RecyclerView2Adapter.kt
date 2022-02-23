package com.example.bolkarappinternshiptask.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R

class RecyclerView2Adapter : RecyclerView.Adapter<RecyclerView2Adapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView2Adapter.ViewHolderClass {
        val view: ViewHolderClass =ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview2_item,parent,false))

        return view
    }

    override fun onBindViewHolder(holder: RecyclerView2Adapter.ViewHolderClass, position: Int) {

    }

    override fun getItemCount(): Int {
        return 0
    }


    class ViewHolderClass (itemView:View) : RecyclerView.ViewHolder(itemView) {
    }

}