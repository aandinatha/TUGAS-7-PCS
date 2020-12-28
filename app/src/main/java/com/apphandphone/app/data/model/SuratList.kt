package com.apphandphone.app.data.model

data class SuratList (
    val status: Int,
    val jumlah: Int,
    val data: List<Surat> = arrayListOf()
)