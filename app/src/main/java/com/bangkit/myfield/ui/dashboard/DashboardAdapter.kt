package com.bangkit.myfield.ui.dashboard

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class DashboardAdapter(fragment: DashboardFragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position){
            0 -> fragment = ProsesFragment()
            1 -> fragment = HistoryFragment()
        }
        return  fragment as Fragment
    }
}