package com.example.bolkarappinternshiptask.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.RecyclerView
import com.example.bolkarappinternshiptask.R
import com.example.bolkarappinternshiptask.databinding.ActivityMainBinding
import com.example.bolkarappinternshiptask.repository.BolkarClubRepository
import com.example.bolkarappinternshiptask.retrofit.ApiInterface
import com.example.bolkarappinternshiptask.retrofit.RetroFitInstance
import com.example.bolkarappinternshiptask.viewmodel.BolkarClubViewModel
import com.example.bolkarappinternshiptask.viewmodel.ViewModelFactory
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView1=binding.recyclerView1
        recyclerView2=binding.recyclerView2

        // setting properties to action bar
        supportActionBar?.apply {
            displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            setDisplayShowCustomEnabled(true)
            setCustomView(R.layout.actionbar_layout)
            val toolbar: androidx.appcompat.widget.Toolbar = customView.parent as androidx.appcompat.widget.Toolbar
            toolbar.setContentInsetsAbsolute(0,0)
            toolbar.setPadding(0,0,0,0)
        }

        val apiInterface:ApiInterface = RetroFitInstance.instanceOfRetrofitWithApi
        val bolkarClubRepository=BolkarClubRepository(apiInterface)

        // initialize viewmodel using AndroidViewModelFactory
        val viewModel = ViewModelProvider(this,ViewModelFactory(bolkarClubRepository)).get(BolkarClubViewModel::class.java)
            viewModel.host.observe(this, {
                Log.d("Host","Host data is: "+it.n + " " + it.u)
            })

    }
}