package com.apphandphone.app.ui.surat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apphandphone.app.data.model.ActionState
import com.apphandphone.app.data.model.Surat
import com.apphandphone.app.data.repository.SuratRepository
import kotlinx.coroutines.launch

class SuratViewModel : ViewModel() {
    private val repo: SuratRepository by lazy { SuratRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Surat>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listSurat(){
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listSurat()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }
}