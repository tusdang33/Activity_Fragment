package com.kaizm.learnsenddataandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaizm.learnsenddataandroid.databinding.FragmentFirstBinding
import com.kaizm.learnsenddataandroid.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    interface PassData {
        fun passData(string: String)
    }

    private lateinit var passData: PassData

    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        passData = context as? PassData ?: throw RuntimeException("$context must implement OnDataSentListener")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val string = arguments?.getString("string")
        binding.tvResult.text = string

        binding.send.setOnClickListener {
            passData.passData("Data from second Fragment")
        }

    }
}