package com.apphandphone.app.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Surat (
    val judul : String = "",
    val link: String = "",
    val waktu: String = "",
    val tipe: String = "",
    val poster: String = "",
    val kutipan: String = ""

) : Parcelable