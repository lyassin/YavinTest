package com.yavin.bus.busticket.com.yavin.bus.busticket.view

import android.os.Bundle
import com.yavin.bus.busticket.R
import com.yavin.bus.busticket.com.yavin.bus.busticket.TicketOptions
import com.yavin.bus.busticket.com.yavin.bus.busticket.base.BaseActivity

class PurchasingActivity : BaseActivity(){

    private val ticketOptions = TicketOptions(0, 0, 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: TicketOptionsBinding =
            DataBindingUtil.setContentView(this, R.layout.purchasing)
        binding.ticketOptions = ticketOptions

    }

}
