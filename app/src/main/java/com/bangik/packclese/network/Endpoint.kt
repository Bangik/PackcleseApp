package com.bangik.packclese.network

import com.bangik.packclese.model.response.Wrapper
import com.bangik.packclese.model.response.checkout.CheckoutLaundryResponse
import com.bangik.packclese.model.response.home.HomeResponse
import com.bangik.packclese.model.response.login.LoginResponse
import com.bangik.packclese.model.response.profile.ProfileEditResponse
import com.bangik.packclese.model.response.service.ServiceResponse
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

    @GET("jenis-layanan")
    fun home() : Observable<Wrapper<HomeResponse>>

    @GET("data-services?id=1")
    fun laundry() : Observable<Wrapper<ServiceResponse>>

    @FormUrlEncoded
    @POST("checkout-laundry")
    fun checkoutLaundry(@Field("user_id") user_id:String,
                        @Field("total") total:String,
                        @Field("service_id") service_id:String,
                        @Field("address") address:String,
                        @Field("weight") weight:String,
                        @Field("antar") antar:String,
                        @Field("paymentMethod") paymentMethod:String) : Observable<Wrapper<CheckoutLaundryResponse>>

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