package com.bitcodetech.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var txtInfo : TextView
    private lateinit var edtInfo : EditText
    private lateinit var btnSetInfo : Button
    private lateinit var btnFetchInfo : Button

    private lateinit var infoViewModel: InfoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        initViewModels()
        initObservers()
        initListeners()
    }

    private fun initObservers() {
        /*infoViewModel.infoLiveData.observe(
            this,
            object : Observer<String> {
                override fun onChanged(value: String) {
                    txtInfo.text = value
                }
            }
        )*/

        infoViewModel.infoLiveData.observe(
            this
        ) {
            txtInfo.text = it
        }
    }

    private fun initViewModels() {
        //var infoViewModel = InfoViewModel() //not good this is not attached to view
        infoViewModel = ViewModelProvider(
            this,
            MyViewModelFactory( InfoRepository() )
        ).get(InfoViewModel::class.java)
    }

    private fun initListeners() {
        btnSetInfo.setOnClickListener {

        }

        btnFetchInfo.setOnClickListener {
            infoViewModel.fetchInfo()
        }
    }

    private fun initViews() {
        setContentView(R.layout.activity_main)
        txtInfo = findViewById(R.id.txtInfo)
        edtInfo = findViewById(R.id.edtInfo)
        btnSetInfo = findViewById(R.id.btnSetInfo)
        btnFetchInfo = findViewById(R.id.btnFetchInfo)
    }
}