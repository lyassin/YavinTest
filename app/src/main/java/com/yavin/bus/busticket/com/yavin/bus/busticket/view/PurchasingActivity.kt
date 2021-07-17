package com.yavin.bus.busticket.com.yavin.bus.busticket.view

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yavin.bus.busticket.R
import com.yavin.bus.busticket.com.yavin.bus.busticket.base.BaseActivity
import com.yavin.bus.busticket.com.yavin.bus.busticket.utils.YavinConstant
import com.yavin.bus.busticket.com.yavin.bus.busticket.viewmodel.PurchasingViewModel
import com.yavin.bus.busticket.com.yavin.bus.busticket.viewmodel.PurchasingViewModelFactory
import com.yavin.bus.busticket.databinding.PurchasingBinding
import timber.log.Timber


class PurchasingActivity : BaseActivity() {

    private lateinit var viewModel: PurchasingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: PurchasingBinding =
            DataBindingUtil.setContentView(this, R.layout.purchasing)
        val factory = PurchasingViewModelFactory()
        viewModel = ViewModelProvider(this, factory).get(PurchasingViewModel::class.java)
        binding.ticketOptions = viewModel as PurchasingViewModel
        binding.lifecycleOwner = this
        Timber.plant(Timber.DebugTree())
    }

    fun order(v: View) {
        Timber.i("order Single Journey tickets: " + viewModel.inputSingleJourney.value +
        " Day Tickets: " + viewModel.inputDayTicket.value +
        " week tickets: " + viewModel.inputWeekTicket.value)
        val intent = Intent()
        intent.component =
            ComponentName("com.yavin.macewindu", "com.yavin.macewindu.PaymentActivity")
        intent?.putExtra(
            YavinConstant.AMOUNT,
            (viewModel.totalTicketPrice.value?.toDouble()!! * 100).toInt()
        )
        intent?.putExtra(YavinConstant.CURRENCY, "EUR")
        intent?.putExtra(YavinConstant.MEDIUM, "CB")
        intent?.putExtra(YavinConstant.TRANSACTION_TYPE, "Debit")
        intent?.putExtra(YavinConstant.SHOW_PRE_PAY, true)
        intent?.putExtra(YavinConstant.SHOW_POST_PAY, true)
        intent?.putExtra(YavinConstant.SHOW_ONLY_LAST_POST_PAY, false)
        startActivityForResult(intent, 0)
        finish()
    }
}
