package com.elbourn.android.wifisetup.fragments

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.elbourn.android.wifisetup.MainActivity
import com.elbourn.android.wifisetup.R

class WifiSetupFragment : Fragment() {
    val TAG = javaClass.simpleName
    val APP = MainActivity.APP


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wifisetup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "start onViewCreated")
        startWifiSetup()
        Log.i(TAG, "end onViewCreated")
    }

    fun startWifiSetup() {
        startActivity(Intent(Settings.ACTION_WIFI_SETTINGS));
        activity?.finish()
    }
}