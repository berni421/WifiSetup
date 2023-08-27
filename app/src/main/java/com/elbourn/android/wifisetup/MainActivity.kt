package com.elbourn.android.wifisetup

import android.os.Bundle
import android.util.Log
import androidx.activity.OnBackPressedCallback


class MainActivity : OptionsMenu() {
    val TAG = javaClass.simpleName
    val APP = MainActivity.APP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "start onCreate. APP:" + APP + " TAG:" + TAG)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this /* lifecycle owner */,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Back is pressed... Finishing the activity
                    finishAffinity()
                }
            })
    }

    companion object {
        val APP = "WifiSetup"
    }
}