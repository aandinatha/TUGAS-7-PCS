package com.apphandphone.app.ui.surat

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.apphandphone.app.R
import com.apphandphone.app.data.model.Surat
import com.apphandphone.app.databinding.ItemSuratBinding
import com.apphandphone.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class SuratAdapter(val context: Context) : BaseAdapter<Surat>(R.layout.item_surat) {
    override fun onBind(binding: ViewDataBinding?, data: Surat) {
        val mBinding = binding as ItemSuratBinding
        Glide.with(context).load(data.poster).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: Surat) {
        val intent = Intent(context, SuratActivity::class.java)
        intent.putExtra(SuratActivity.OPEN_SURAT, data)
        context.startActivity(intent)
    }

}
