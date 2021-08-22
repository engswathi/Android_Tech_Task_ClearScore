package com.example.androidtectask

import com.example.androidtectask.Interfaces.RetrofitInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bikomobile.donutprogress.DonutProgress
import com.example.androidtectask.Model.CreditReportDatas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val BASE_URL = "https://android-interview.s3.eu-west-2.amazonaws.com/"


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getInfo()
    }
    private fun getInfo() {
       val donutProgressView: DonutProgress = findViewById(R.id.donutProgressView) as DonutProgress

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val retrofitInterface = retrofit.create(RetrofitInterface::class.java)
        val getCreditStatus: Call<CreditReportDatas> = retrofitInterface.getCreditData()

        getCreditStatus.enqueue(object :Callback<CreditReportDatas>{
            override fun onResponse(
                call: Call<CreditReportDatas>,
                response: Response<CreditReportDatas>
            ) {
                val responseBody = response.body()!!
                val progressValue = responseBody.creditReportInfo.score
                donutProgressView.progress = progressValue
            }
            override fun onFailure(call: Call<CreditReportDatas>, t: Throwable) {
                Log.e("Failed",t.toString())
            }

        })
    }}

