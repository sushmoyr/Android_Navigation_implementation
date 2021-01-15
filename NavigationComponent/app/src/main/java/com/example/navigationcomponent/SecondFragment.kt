package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigationcomponent.databinding.FragmentFirstBinding
import com.example.navigationcomponent.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding : FragmentSecondBinding? = null
    private val binding get() = _binding!!

    val args:SecondFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        binding.textView2.text = args.number.toString()

        binding.textView2.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_secondFragment_to_firstFragment)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}