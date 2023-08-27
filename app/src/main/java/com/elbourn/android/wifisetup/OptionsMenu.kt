package com.elbourn.android.wifisetup

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elbourn.android.wifisetup.fragments.IntroFragment

open class OptionsMenu : AppCompatActivity() {
    val TAGO:String = javaClass.simpleName

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        val context: Context = applicationContext
        val introCheckBox = menu.findItem(R.id.menuIntroOff)
        introCheckBox.isChecked = IntroFragment.getIntroCheckBox(context)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.menuIntroOff -> {
                setIntroductionOff(item)
                true
            }
            R.id.menuDonate -> {
                startDonationWebsite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun setIntroductionOff(item: MenuItem) {
        val context: Context = getApplicationContext()
        val subscriptionsIntroOff = !item.isChecked
        item.isChecked = subscriptionsIntroOff
        IntroFragment.setIntroCheckBox(context, subscriptionsIntroOff)
        Log.i(TAGO, "subscriptionsIntroOff: $subscriptionsIntroOff")
    }

    fun startDonationWebsite() {
        Log.i(TAGO, "start startDonationWebsite")
        val context: Context = getApplicationContext()
        runOnUiThread(Runnable {
            val msg = "Starting browser to feed the cat ..."
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        })
        val url = "https://www.elbourn.com/feed-the-cat/"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
        Log.i(TAGO, "end startDonationWebsite")
    }
}