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


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView


    private val listOfMembers= ArrayList<Person>()
    private val listOfAllData = ArrayList<AllData>()
    private val listOfPersonsForRv1 = ArrayList<Person>()
    private val lisOfProfileUrlsForRv1 = ArrayList<String>()
    private val listOfProfileUrlsForMembers = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView1=binding.recyclerView1
        recyclerView2=binding.recyclerView2

        val adapterForRv1 = RecyclerView1Adapter(listOfPersonsForRv1,lisOfProfileUrlsForRv1,this)
        val adapterForRv2 = RecyclerView2Adapter()

        val apiInterface:ApiInterface = RetroFitInstance.instanceOfRetrofitWithApi
        val bolkarClubRepository=BolkarClubRepository(apiInterface)

        // initialize viewmodel using AndroidViewModelFactory
        val viewModel = ViewModelProvider(this,ViewModelFactory(bolkarClubRepository)).get(BolkarClubViewModel::class.java)
            viewModel.data.observe(this, {

                Log.d("Data","All Data is: "+it.data.members)
                listOfAllData.add(it)
                listOfPersonsForRv1.add(it.data.host)

                // combining host speaker and moderator data for rv1
                for (speaker in it.data.speakers) {
                    listOfPersonsForRv1.add(speaker)
                }
                for (moderator in it.data.moderators) {
                    listOfPersonsForRv1.add(moderator)
                }
                for (member in it.data.members) {
                    listOfMembers.add(member)
                }

                for (i in listOfPersonsForRv1) {
                    val imageurl = RetroFitInstance.baseUrlForProfilePic+i.u+"jpg"
                    lisOfProfileUrlsForRv1.add(imageurl)
                }

                for (i in listOfMembers) {
                    val imageurl = RetroFitInstance.baseUrlForProfilePic+i.u+"jpg"
                    lisOfProfileUrlsForRv1.add(imageurl)
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

                    Glide.with(this@MainActivity).load(RetroFitInstance.baseUrlForProfilePic + it.data.host.u+".jpg").into(customView.findViewById(R.id.profileimg))

                    val toolbar: androidx.appcompat.widget.Toolbar = customView.parent as androidx.appcompat.widget.Toolbar
                    toolbar.setContentInsetsAbsolute(0,0)
                    toolbar.setPadding(0,0,0,0)
                }
            })
        recyclerView1.layoutManager=GridLayoutManager(this,3)
        recyclerView1.adapter=RecyclerView1Adapter(listOfPersonsForRv1,lisOfProfileUrlsForRv1,this)
        recyclerView2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView2.adapter=RecyclerView2Adapter(listOfMembers)

    }
}