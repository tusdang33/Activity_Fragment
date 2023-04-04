package com.kaizm.learnsenddataandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaizm.learnsenddataandroid.databinding.FragmentFirstBinding
import com.kaizm.learnsenddataandroid.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle().apply {
            putString("string", binding.tv.text.toString())
        }
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle

        binding.send.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.fragment, secondFragment)
                .addToBackStack(null).commit()
        }
    }

}