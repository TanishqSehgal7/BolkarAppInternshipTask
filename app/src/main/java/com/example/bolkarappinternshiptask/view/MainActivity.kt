package com.example.bolkarappinternshiptask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bolkarappinternshiptask.Adapters.RecyclerView1Adapter
import com.example.bolkarappinternshiptask.Adapters.RecyclerView2Adapter
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.databinding.ActivityMainBinding
import com.example.bolkarappinternshiptask.modelClass.*
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance
import com.example.bolkarappinternshiptask.viewmodel.BolkarClubViewModel
import com.example.bolkarappinternshiptask.viewmodel.ViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView


    val listOfMembers= ArrayList<Person>()
    val listOfAllData = ArrayList<AllData>()
    val listOfPersonsForRv1 = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView1=binding.recyclerView1
        recyclerView2=binding.recyclerView2

        recyclerView1.layoutManager=GridLayoutManager(this,3)
        recyclerView1.adapter=RecyclerView1Adapter(this,listOfPersonsForRv1)
        recyclerView2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter=RecyclerView2Adapter(this,listOfMembers)
        val adapterForRv1 = RecyclerView1Adapter(this)
        val adapterForRv2 = RecyclerView2Adapter(this)

        val apiInterface:ApiInterface = RetroFitInstance.instanceOfRetrofitWithApi
        val bolkarClubRepository=BolkarClubRepository(apiInterface)

        // initialize viewmodel using AndroidViewModelFactory
        val viewModel = ViewModelProvider(this,ViewModelFactory(bolkarClubRepository)).get(BolkarClubViewModel::class.java)
            viewModel.data.observe(this, {

                Log.d("Data","All Data is: "+it.data.members)
                    listOfAllData.add(it)
                listOfPersonsForRv1.add(it.data.host)
                for (speaker in it.data.speakers) {
                    listOfPersonsForRv1.add(speaker)
                }
                for (moderator in it.data.moderators) {
                    listOfPersonsForRv1.add(moderator)
                }
                for (member in it.data.members) {
                    listOfMembers.add(member)
                }
                Log.d("Members", listOfMembers.toString())
                adapterForRv1.setPersonList(listOfPersonsForRv1)
                adapterForRv2.setMemberList(listOfMembers)
                // setting properties to action bar
                supportActionBar?.apply {
                    displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
                    setDisplayShowCustomEnabled(true)
                    setCustomView(R.layout.actionbar_layout)
                    customView.findViewById<TextView>(R.id.appBarHeading).text = it.data.topic
//                    var imageUrl=""
//                    CoroutineScope(Dispatchers.IO).launch {
//                        imageUrl = viewModel.profileUrl(it.data.host.u)
//                        Log.d("MainActivity","Image Url is: "  + imageUrl)
//                    }
//                    Glide.with(this@MainActivity).load("imageUrl").into(customView.findViewById(R.id.profileimg))
                    val toolbar: androidx.appcompat.widget.Toolbar = customView.parent as androidx.appcompat.widget.Toolbar
                    toolbar.setContentInsetsAbsolute(0,0)
                    toolbar.setPadding(0,0,0,0)
                }
            })
    }
}