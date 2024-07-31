package com.auth.oschmidauthjwt.network

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.http.POST
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Headers

val localUrl="http://10.0.2.2:3001/"
val retrofitAuthentication = Retrofit.Builder()
    .baseUrl(localUrl)
    .addConverterFactory(GsonConverterFactory
        .create())
    .build()

data class UserLoginRequest(@SerializedName("user_name") val username:String,  @SerializedName("password")val password:String)
data class UserLoginResponse(val auth:String,val ref:String)
data class UserTokenCheckResponse(val check:String)
interface Authentication{
    @FormUrlEncoded
    @POST("auth/login")
    fun loginUser(@Field("username") username:String, @Field("password")password: String):Call<UserLoginResponse>

    @POST("auth/refresh")
    fun refreshToken(@HeaderMap headers: Map<String, String>):Call<UserLoginResponse>

    @GET("auth/test")
    fun testGet(@HeaderMap headers: Map<String, String>):Call<UserTokenCheckResponse>
}

object SabencosAuthentication {
    val authenticationApi:Authentication by lazy {
        retrofitAuthentication.create(Authentication::class.java)
    }
}

