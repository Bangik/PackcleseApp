package com.bangik.packclese.ui.profile.account

import android.view.View
import androidx.navigation.Navigation
import com.bangik.packclese.R
import com.bangik.packclese.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class EditPresenter (private val view: EditContract.View) : EditContract.Presenter {
    private val mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun subimEdit(id:String , name: String, email: String, address: String, phoneNumber: String) {

        val disposable = HttpClient.getInstance().getApi()!!.edit(id,name,email,address,phoneNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {


                    if (it.meta?.status.equals("success",true)){
                        it.data?.let { it1 -> view.onEditSuccess(it1) }
                    } else {
                        it.meta?.message?.let { it1 -> view.onEditFailed(it1) }
                    }
                },
                {

                    view.onEditFailed(it.message.toString())
                }
            )
        mCompositeDisposable!!.add(disposable)
    }


    override fun subscribe() {

    }

    override fun unSubscribe() {
        mCompositeDisposable!!.clear()
    }


}