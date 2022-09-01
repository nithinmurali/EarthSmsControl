package com.fallenbug.deviearth

import android.Manifest
import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.fallenbug.deviearth.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val earthNumber = "+919947368977"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_NO
        )

        getPermissions()

        binding.allOff.setOnClickListener {
            sendSms("all off")
        }
        binding.allOn.setOnClickListener {
            sendSms("all on")
        }


        binding.e1Off.setOnClickListener {
            sendSms("off")
        }
        binding.e1On.setOnClickListener {
            sendSms("on")
        }


        binding.e2Off.setOnClickListener {
            sendSms("e2off")
        }
        binding.e2On.setOnClickListener {
            sendSms("e2on")
        }

        binding.status.setOnClickListener {
            sendSms("state")
        }

        setContentView(binding.root)
    }

    fun sendSms(text: String) {
        val dialog = ProgressDialog.show(this, "", "Wait...",
            true
        )
        dialog.show()
        val handler = Handler()
        handler.postDelayed(Runnable { dialog.dismiss() }, 6000) // 3000 milliseconds delay

        SmsManager.getDefault().sendTextMessage(earthNumber,
            null, text, null, null);

    }


    fun getPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.SEND_SMS)) { }
            else { ActivityCompat.requestPermissions(this, listOf(Manifest.permission.SEND_SMS).toTypedArray(),1) }
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_PHONE_STATE)) { }
            else { ActivityCompat.requestPermissions(this, listOf(Manifest.permission.READ_PHONE_STATE).toTypedArray(),1) }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            1 -> {
            }
        }
    }
}