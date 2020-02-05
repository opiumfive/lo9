package com.opiumfive.lo9demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        log.deleteLogFile(this)
        log.startLoggingToFile(this)
        log.debug("doing this")
        log.debug("doing that")
        log.error("oops error")

        log.shareLogFile(this, "opiumfive@gmail.com")

    }
}
