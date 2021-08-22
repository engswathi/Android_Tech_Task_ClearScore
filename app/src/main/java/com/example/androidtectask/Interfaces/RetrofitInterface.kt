package com.example.androidtectask.Interfaces

import com.example.androidtectask.Model.CreditReportDatas
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

public interface RetrofitInterface {

    @Headers("Content-Type: application/json")

    @GET("endpoint.json")
    fun getCreditData() : Call<CreditReportDatas>


//    @Headers("Content-Type: application/json")
//    @GET
//    fun getData(@Url url:String):List<CreditReportDatas>




}