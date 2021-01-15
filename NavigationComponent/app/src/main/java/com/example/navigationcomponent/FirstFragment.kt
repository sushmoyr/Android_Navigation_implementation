package com.example.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.navigationcomponent.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {

    //Essential variables for view binding
    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.textView1.setOnClickListener{
            //create action of navigation
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(22)
            Navigation.findNavController(binding.root).navigate(action)
        }

        return binding.root
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }


}