package com.bangkit.myfield.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bangkit.myfield.databinding.FragmentHomeBinding
import com.bangkit.myfield.detail.ListBadminton
import com.bangkit.myfield.detail.ListFutsal

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val cardFutsal: RelativeLayout = binding.cardFusal
        cardFutsal.setOnClickListener{
            val move = Intent(activity, ListFutsal::class.java)
            activity?.startActivity(move)
        }

        val cardBadminton: RelativeLayout = binding.cardBadminton
        cardBadminton.setOnClickListener {
            val moveBadminton = Intent(activity, ListBadminton::class.java)
            activity?.startActivity(moveBadminton)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}