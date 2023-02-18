package com.example.twoactivityapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    private val NOTIFICATION_ID = 8
    private val CHANNEL_ID = "My Channel"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val arrCircularBtn = findViewById<ImageButton>(R.id.imgbutton)
//        arrCircularBtn.setOnClickListener {
//            intent = Intent(applicationContext, SignIn::class.java)
//            startActivity(intent)
//        }

        val loginBtn = findViewById<Button>(R.id.login)
        val signUpBtn = findViewById<Button>(R.id.signup)
        val toastBtn = findViewById<Button>(R.id.toast)
        val formBtn = findViewById<Button>(R.id.form)
        val formAPI = findViewById<Button>(R.id.formapi)

//      ===================Toast===================
        toastBtn.setOnClickListener {
            Toast.makeText(applicationContext, "Triggered Toast", Toast.LENGTH_SHORT).show()
        }
//      ===================Login Layout===================
        loginBtn.setOnClickListener {
            intent = Intent(applicationContext, SignIn::class.java)
            startActivity(intent)
        }
//      ===================SignUp Layout===================
        signUpBtn.setOnClickListener {
            intent = Intent(applicationContext, SignUp::class.java)
            startActivity(intent)
        }
//      ===================Form Layout===================
        formBtn.setOnClickListener {
            intent = Intent(applicationContext, Form::class.java)
            startActivity(intent)
        }
//      ===================Notification===================
        val notifyBtn = findViewById<Button>(R.id.notify)
        val drawable = ResourcesCompat.getDrawable(resources, R.drawable.frame, null)
        val bitmapDrawable = drawable as BitmapDrawable
        val largeIcon = bitmapDrawable.bitmap
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notification : Notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = Notification.Builder(applicationContext)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.shape)
                .setContentText("Notification Using Button")
                .setSubText("This is a Notification Triggered using Button")
                .setChannelId(CHANNEL_ID)
                .build()
            nm.createNotificationChannel(
                NotificationChannel(
                    CHANNEL_ID,
                    "Click",
                    NotificationManager.IMPORTANCE_HIGH
                )
            )
        } else {
            notification = Notification.Builder(applicationContext)
                .setLargeIcon(largeIcon)
                .setSmallIcon(R.drawable.frame)
                .setContentText("Notification Using Button")
                .setSubText("This is a Notification Triggered using Button")
                .build()
        }

        notifyBtn.setOnClickListener {
            nm.notify(NOTIFICATION_ID, notification)
        }
    }
}
