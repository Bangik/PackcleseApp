package com.bangik.packclese.ui.profile.account

import android.view.View
import com.bangik.packclese.base.BasePresenter
import com.bangik.packclese.model.response.profile.ProfileEditResponse

interface EditContract {
    interface View {
        fun onEditSuccess(ProfileEditResponse: ProfileEditResponse)
        fun onEditFailed(message:String)
    }

    interface Presenter : EditContract, BasePresenter {
        fun subimEdit(id:String, name:String, email:String, address:String, phoneNumber: String)
    }
}

