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
import com.bangkit.myfield.R
import com.bangkit.myfield.databinding.FragmentHomeBinding
import com.bangkit.myfield.detail.ListBadminton
import com.bangkit.myfield.detail.ListFutsal
import java.util.*

class HomeFragment : Fragment(), View.OnClickListener {

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

        val greetings: TextView = binding.textHomeGreeting
        homeViewModel.text.observe(viewLifecycleOwner) {
            greetings.text = it
        }

        val cardFutsal: RelativeLayout = binding.cardFusal
        cardFutsal.setOnClickListener{
            val moveFutsal = Intent(activity, ListFutsal::class.java)
            activity?.startActivity(moveFutsal)
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

    override fun onClick(v: View) {
        if (v.id == R.id.back_img) {
            val mCategoryFragment = HomeFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.container_futsal, mCategoryFragment, HomeFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}