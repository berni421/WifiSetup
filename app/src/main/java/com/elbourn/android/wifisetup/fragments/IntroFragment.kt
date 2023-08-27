package com.elbourn.android.wifisetup.fragments

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.elbourn.android.wifisetup.MainActivity
import com.elbourn.android.wifisetup.R

class IntroFragment : Fragment() {
    val TAG = javaClass.simpleName
    val APP = MainActivity.APP

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG, "start onViewCreated")
        if (getIntroCheckBox(context)) {
            startWifiSetupFragment()
        } else {
            setupButtons(view)
        }
        Log.i(TAG, "end onViewCreated")
    }

    fun setupButtons(view: View) {
        Log.i(TAG, "start setupButtons")
        val introImageButton: ImageButton = view.findViewById<ImageButton>(R.id.introImageButton)
        introImageButton.setOnClickListener(View.OnClickListener {
            Log.i(TAG, "introImageButton clicked")
            startWifiSetupFragment()
        })
        val introCheckBox: CheckBox = view.findViewById<CheckBox>(R.id.introCheckBox)
        introCheckBox.setOnClickListener(View.OnClickListener { v ->
            Log.i(TAG, "introCheckBox clicked")
            val checkBox: CheckBox = v as CheckBox
            val context = context
            setIntroCheckBox(context, checkBox.isChecked)
        })
        Log.i(TAG, "start setupButtons")
    }

    fun startWifiSetupFragment() {
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_introFragment_to_WifiSetupFragment)
    }

    companion object {
        val TAG = IntroFragment.toString()
        val APP = MainActivity.APP

        fun getIntroCheckBox(context: Context?): Boolean {
            val sharedPreferences: SharedPreferences =
                context!!.getSharedPreferences(APP, Context.MODE_PRIVATE)
            val introCheckBox: Boolean = sharedPreferences.getBoolean("introCheckBox", false)
            Log.i(TAG, "introCheckBox: $introCheckBox")
            return introCheckBox
        }

        fun setIntroCheckBox(context: Context?, checkBox: Boolean) {
            val sharedPreferences: SharedPreferences =
                context!!.getSharedPreferences(APP, Context.MODE_PRIVATE)
            if (checkBox) {
                sharedPreferences.edit().putBoolean("introCheckBox", true).apply()
            } else {
                sharedPreferences.edit().putBoolean("introCheckBox", false).apply()
            }
        }
    }
}

