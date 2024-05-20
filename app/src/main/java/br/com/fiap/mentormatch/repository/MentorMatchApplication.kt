package br.com.fiap.mentormatch.repository

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.annotation.RequiresApi

class MentorMatchApplication: Application() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate() {
        super.onCreate()
        val warningChannel= NotificationChannel(
            "match_notification",
            "Match",
            NotificationManager.IMPORTANCE_HIGH
        )
        val warningManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        warningManager.createNotificationChannel(warningChannel)
    }
}