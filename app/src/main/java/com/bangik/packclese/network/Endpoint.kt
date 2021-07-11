package com.bangik.packclese.network

import com.bangik.packclese.model.response.Wrapper
import com.bangik.packclese.model.response.login.LoginResponse
import com.bangik.packclese.model.response.profile.ProfileEditResponse
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Endpoint {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,
              @Field("password") password:String) : Observable<Wrapper<LoginResponse>>
    @FormUrlEncoded
    @POST("user/edit")
    fun edit(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phoneNumber") phoneNumber: String) : Observable<Wrapper<ProfileEditResponse>>
}