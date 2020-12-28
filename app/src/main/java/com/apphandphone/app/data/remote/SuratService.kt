package com.apphandphone.app.data.remote

import com.apphandphone.app.data.model.SuratList
import retrofit2.Call
import retrofit2.http.GET

interface SuratService {
    @GET("/nasional")
    fun listSurat() : Call<SuratList>


}