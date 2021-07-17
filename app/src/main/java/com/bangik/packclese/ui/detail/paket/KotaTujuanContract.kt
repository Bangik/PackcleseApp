package com.bangik.packclese.ui.detail.paket

import com.bangik.packclese.base.BasePresenter
import com.bangik.packclese.base.BaseView
import com.bangik.packclese.model.response.rajaongkir.KotaResponse

interface KotaTujuanContract {
    interface View: BaseView{
        fun onKotaTujuanSuccess(kotaTujuanResponse: KotaResponse)
        fun onKotaTujuanFailed(message:String)
    }

    interface presenter : KotaTujuanContract,BasePresenter{
        fun getKotaTujuan(id:String)
    }
}