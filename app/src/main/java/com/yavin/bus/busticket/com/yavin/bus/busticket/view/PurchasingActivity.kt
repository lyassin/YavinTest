package com.yavin.bus.busticket.com.yavin.bus.busticket.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yavin.bus.busticket.R
import com.yavin.bus.busticket.com.yavin.bus.busticket.base.BaseActivity
import com.yavin.bus.busticket.com.yavin.bus.busticket.viewmodel.PurchasingViewModel
import com.yavin.bus.busticket.com.yavin.bus.busticket.viewmodel.PurchasingViewModelFactory
import com.yavin.bus.busticket.databinding.PurchasingBinding

class PurchasingActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: PurchasingBinding =
            DataBindingUtil.setContentView(this, R.layout.purchasing)
        val factory = PurchasingViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(PurchasingViewModel::class.java)
        binding.ticketOptions = viewModel
        binding.lifecycleOwner = this
    }

}
