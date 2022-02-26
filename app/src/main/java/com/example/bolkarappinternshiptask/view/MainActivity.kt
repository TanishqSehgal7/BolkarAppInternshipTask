package com.example.bolkarappinternshiptask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
import kotlinx.coroutines.delay

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

        installSplashScreen()
        Toast.makeText(this,"Please make sure you are connected to the internet!",Toast.LENGTH_SHORT).show()

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView1=binding.recyclerView1
        recyclerView2=binding.recyclerView2

        val apiInterface:ApiInterface = RetroFitInstance.instanceOfRetrofitWithApi
        val bolkarClubRepository=BolkarClubRepository(apiInterface)

        // specify layouts for recyclerviews
        recyclerView1.layoutManager=GridLayoutManager(this,3)
        recyclerView2.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        // initialize viewmodel using AndroidViewModelFactory
        val viewModel = ViewModelProvider(this,ViewModelFactory(bolkarClubRepository)).get(BolkarClubViewModel::class.java)
            viewModel.data.observe(this, {

                Log.d("Data","All Data is: "+it.data.members)
                listOfAllData.add(it)
                listOfPersonsForRv1.add(it.data.host)

                it.data.speakers.reversed()
                // combining host speaker and moderator data for rv1
                for (i in 1 until it.data.speakers.size) {
                    // reversing list of speakers and then adding to listOfPersonsForRv1
                    val list: MutableList<Person> = it.data.speakers.reversed() as MutableList<Person>
                    listOfPersonsForRv1.add(list[i])
                }
//                for (moderator in it.data.moderators) {
//                    listOfPersonsForRv1.add(moderator)
//                }
                for (member in it.data.members) {
                    listOfMembers.add(member)
                }

                for (i in listOfPersonsForRv1) {
                    val imageurl = RetroFitInstance.baseUrlForProfilePic+i.u+".jpg"
                    lisOfProfileUrlsForRv1.add(imageurl)
                }

                for (i in listOfMembers) {
                    val imageurl = RetroFitInstance.baseUrlForProfilePic+i.u+".jpg"
                    listOfProfileUrlsForMembers.add(imageurl)
                }

                Log.d("Members", listOfMembers.toString())

                // setting properties to action bar
                supportActionBar?.apply {

                    displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
                    setDisplayShowCustomEnabled(true)
                    setCustomView(R.layout.actionbar_layout)
                    customView.findViewById<TextView>(R.id.appBarHeading).text = it.data.topic
                    customView.findViewById<TextView>(R.id.numberOfPeople).text = listOfPersonsForRv1.size.toString()

                    Glide.with(this@MainActivity).load(RetroFitInstance.baseUrlForProfilePic + it.data.host.u+".jpg").into(customView.findViewById(R.id.profileimg))

                    val toolbar: androidx.appcompat.widget.Toolbar = customView.parent as androidx.appcompat.widget.Toolbar
                    toolbar.setContentInsetsAbsolute(0,0)
                    toolbar.setPadding(0,0,0,0)
                }

                // binidng recyclerview adapteters to activity and passsing all data as lists to adapters
                recyclerView1.adapter=RecyclerView1Adapter(listOfPersonsForRv1,lisOfProfileUrlsForRv1,this)
                recyclerView2.adapter=RecyclerView2Adapter(listOfMembers,listOfProfileUrlsForMembers,this)
                Log.d("ProfileUrlList", listOfProfileUrlsForMembers.toString() +"\n\n" + lisOfProfileUrlsForRv1)
            })
    }
}