package com.bangik.packclese.ui.profile.account

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bangik.packclese.R
import com.bangik.packclese.model.dummy.ProfileMenuModel
import com.bangik.packclese.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_profile_account.*

class ProfileAccountFragment : Fragment(), ProfileMenuAdapter.ItemAdapterCallback {

    private var menuArrayList: ArrayList<ProfileMenuModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()

        var adapter = ProfileMenuAdapter(menuArrayList, this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy(){
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Edit Profile"))
        menuArrayList.add(ProfileMenuModel("Home Address"))
        menuArrayList.add(ProfileMenuModel("Security"))
        menuArrayList.add(ProfileMenuModel("Payment"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {

        if (data.title == "Edit Profile") {

            val intent = Intent(activity, EditActivity::class.java)
            startActivity(intent)

        }else if (data.title == "Home Address"){
            Toast.makeText(context, "Home Address", Toast.LENGTH_SHORT).show()
        }else if (data.title == "Security"){
            Toast.makeText(context, "Security", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Payment", Toast.LENGTH_SHORT).show()
        }
    }

}