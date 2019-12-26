package com.soft.attendancekt.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.soft.attendancekt.R
import kotlinx.android.synthetic.main.fragment_list_item.*

class FragmentListMember : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener{
            val fragmentAddMember = FragmentAddMember()
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.recyclerViewFragment, fragmentAddMember)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            fab.hide()
        }
    }

}