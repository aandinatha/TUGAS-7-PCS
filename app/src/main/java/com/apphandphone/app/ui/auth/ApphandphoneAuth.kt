package com.apphandphone.app.ui.auth

import android.content.Context
import com.apphandphone.app.data.model.ActionState
import com.apphandphone.app.data.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object ApphandphoneAuth {
    fun logout(contect: Context, callback: ((ActionState<Boolean>)-> Unit)? = null){
        val repo = AuthRepository(contect)
        CoroutineScope(Dispatchers.IO).launch {
            val resp = repo.logout()
            with(Dispatchers.Main){
                if (callback != null) callback.invoke(resp)
            }
        }
    }
}