package com.antukcapstone.antuk.ui.screens.account.components

import android.content.Context
import android.media.MediaPlayer
import android.os.Handler
import com.antukcapstone.antuk.R

class AlarmPlayer(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null
    private val handler = Handler()

    fun playAlarmForDuration(durationInMillis: Long) {
        mediaPlayer = MediaPlayer.create(context, R.raw.alarm)
        mediaPlayer?.isLooping = true // Set if you want the sound to loop
        mediaPlayer?.start()

        handler.postDelayed({
            stopAlarm()
        }, durationInMillis)
    }

    fun stopAlarm() {
        mediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        mediaPlayer = null
        handler.removeCallbacksAndMessages(null)
    }
}
