package com.yavin.bus.busticket.com.yavin.bus.busticket.view

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.yavin.bus.busticket.R
import com.yavin.bus.busticket.com.yavin.bus.busticket.base.BaseActivity

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backgroundImage: ImageView = findViewById(R.id.logo_icon)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundImage.startAnimation(sideAnimation)
    }

}
