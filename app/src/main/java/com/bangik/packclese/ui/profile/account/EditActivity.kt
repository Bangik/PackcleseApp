package com.bangik.packclese.ui.profile.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bangik.packclese.Packclese
import com.bangik.packclese.R
import com.bangik.packclese.model.response.login.User
import com.bangik.packclese.model.response.profile.ProfileEditResponse
import com.bangik.packclese.ui.MainActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity(), EditContract.View {
    lateinit var id: String
    lateinit var presenter: EditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        presenter = EditPresenter(this)


        initdummy()

        btnEditProfile.setOnClickListener(){
            var name = edt_username.text.toString()
            var email = edt_email.text.toString()
            var address = edt_address.text.toString()
            var phoneNumber = edt_phoneNumber.text.toString()


            if (email.isNullOrEmpty()) {
                edt_email.error = "Silahkan masukkan Email Anda"
                edt_email.requestFocus()

            } else if (name.isNullOrEmpty()) {
                edt_username.error = "Silahkan masukkan Username Anda"
                edt_username.requestFocus()
            }else if (address.isNullOrEmpty()){
                edt_username.error = "Silahkan masukkan Username Anda"
                edt_username.requestFocus()
            }else if (phoneNumber.isNullOrEmpty()){
                edt_username.error = "Silahkan masukkan Username Anda"
                edt_username.requestFocus()
            }
            else {
                presenter.subimEdit(id,name, email, address, phoneNumber)


            }
//            presenter.subimtLogin("admin@gmail.com", "admin")
        }
    }


    override fun onEditSuccess(ProfileEditResponse: ProfileEditResponse) {

        val gson = Gson()
        val json = gson.toJson(ProfileEditResponse.user)
        Packclese.getApp().setUser(json)

        Toast.makeText(applicationContext,"Kamu Berhasil"  , Toast.LENGTH_SHORT).show()

        val home = Intent(applicationContext, MainActivity::class.java)

        startActivity(home)
    }


    override fun onEditFailed(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }




    fun initdummy() {
        var user = Packclese.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)

        if (userResponse.name.isNullOrEmpty()){
            Toast.makeText(applicationContext, "data telah diubah harap diupdate", Toast.LENGTH_LONG).show()
        }else{

            id = userResponse.id.toString()
            edt_username.setText(userResponse.name.toString())
            edt_email.setText(userResponse.email.toString())
            edt_address.setText(userResponse.address.toString())
            edt_phoneNumber.setText(userResponse.phoneNumber.toString())
        }

    }


}