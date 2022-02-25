package com.example.bolkarappinternshiptask.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.modelClass.Person
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance
import com.example.bolkarappinternshiptask.view.MainActivity
import com.example.bolkarappinternshiptask.viewmodel.BolkarClubViewModel
import com.example.bolkarappinternshiptask.viewmodel.ViewModelFactory
import java.lang.reflect.Member

class RecyclerView2Adapter(private val listOfMembers: ArrayList<Person> = ArrayList()) : RecyclerView.Adapter<RecyclerView2Adapter.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView2Adapter.ViewHolderClass {
        val view =ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview2_item,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: RecyclerView2Adapter.ViewHolderClass, position: Int) {
        val currentMember = listOfMembers[position]
        holder.memberName.text =currentMember.n
    }

    override fun getItemCount(): Int {
        return listOfMembers.size
    }

    class ViewHolderClass (itemView:View) : RecyclerView.ViewHolder(itemView) {

        val memberName = itemView.findViewById<TextView>(R.id.OtherUsersNames)
        val memberProfile = itemView.findViewById<ImageView>(R.id.OtherUsersDp)
    }
}