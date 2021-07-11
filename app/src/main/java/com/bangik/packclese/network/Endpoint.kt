package com.bangik.packclese.network

import com.bangik.packclese.model.response.Wrapper
import com.bangik.packclese.model.response.login.LoginResponse
import com.bangik.packclese.model.response.profile.ProfileEditResponse
import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.*

interface Endpoint {
    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email") email:String,
              @Field("password") password:String) : Observable<Wrapper<LoginResponse>>

    @FormUrlEncoded
    @POST("register")
    fun register(@Field("name") name:String,
                 @Field("email") email:String,
                 @Field("password") password:String,
                 @Field("password_confirmation") password_confirmation:String,
                 @Field("address") address:String,
                 @Field("phoneNumber") phoneNumber:String) : Observable<Wrapper<LoginResponse>>

    @Multipart
    @POST("user/photo")
    fun registerPhoto(@Part profileImage: MultipartBody.Part) : Observable<Wrapper<Any>>

    @FormUrlEncoded
    @POST("user/edit")
    fun edit(
        @Field("id") id: String,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("address") address: String,
        @Field("phoneNumber") phoneNumber: String) : Observable<Wrapper<ProfileEditResponse>>
}