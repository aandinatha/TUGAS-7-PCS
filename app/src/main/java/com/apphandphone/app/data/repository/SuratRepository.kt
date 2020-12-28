package com.apphandphone.app.data.repository

import com.apphandphone.app.data.model.ActionState
import com.apphandphone.app.data.model.Surat
import com.apphandphone.app.data.remote.RetrofitApi
import com.apphandphone.app.data.remote.SuratService
import retrofit2.await
import java.lang.Exception

class SuratRepository {
    private val suratService: SuratService by lazy { RetrofitApi.suratService() }

    suspend fun listSurat():ActionState<List<Surat>>{
        return try {
            val list = suratService.listSurat().await()
            ActionState(list.data)
        }catch (e: Exception){
            ActionState(message = e.message, isSuccess = false)
        }
    }

}