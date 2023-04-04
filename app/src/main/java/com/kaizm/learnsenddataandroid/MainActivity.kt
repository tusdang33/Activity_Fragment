package com.kaizm.learnsenddataandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.text.format.Formatter.formatIpAddress
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.kaizm.learnsenddataandroid.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity(), SecondFragment.PassData {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, firstFragment)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, firstFragment)
                commit()
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment, secondFragment)
                commit()
            }
        }

        binding.btnClear.setOnClickListener {
            binding.tvResult.text = "null"
        }
    }

    override fun passData(string: String) {
        binding.tvResult.text = string
    }

}