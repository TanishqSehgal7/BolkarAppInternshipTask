package com.example.bolkarappinternshiptask.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.modelClass.Person
import com.example.bolkarappinternshiptask.view.MainActivity


class RecyclerView2Adapter(
    private var listOfMembers: ArrayList<Person> = ArrayList(),
    private var listOfProfileUrls : ArrayList<String> = ArrayList(),
    private val activity: MainActivity
    ) : RecyclerView.Adapter<RecyclerView2Adapter.ViewHolderClass>() {

    val membersList = this.listOfMembers
    val profileUrls = this.listOfProfileUrls

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view =ViewHolderClass(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview2_item,parent,false))
        return view
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentMember = membersList[position]
        holder.memberName.text =currentMember.n.split(" ")[0]
        Glide.with(activity).load(profileUrls[position]).into(holder.memberProfilePic)

    }

    override fun getItemCount(): Int {
        return listOfMembers.size
    }

    class ViewHolderClass (itemView:View) : RecyclerView.ViewHolder(itemView) {

        val memberName = itemView.findViewById<TextView>(R.id.OtherUsersNames)
        val memberProfilePic = itemView.findViewById<ImageView>(R.id.OtherUsersDp)
    }
}