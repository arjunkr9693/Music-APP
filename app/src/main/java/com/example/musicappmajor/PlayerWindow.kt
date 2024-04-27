package com.example.musicappmajor

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlayerWindow : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_window)
        val startButton = findViewById<Button>(R.id.startMusic)
        val stopButton = findViewById<Button>(R.id.stopMusic)

        startButton.setOnClickListener {
            // Initialize the MediaPlayer if it's not initialized yet
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.test_music) // Replace R.raw.your_music_file with your music file
                mediaPlayer?.isLooping = true // Set to true if you want the music to loop
            }

            // Start playing the music
            mediaPlayer?.start()
        }

        stopButton.setOnClickListener {
            // Stop the music
            mediaPlayer?.stop()
            // Release the MediaPlayer resources
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    override fun onStop() {
        super.onStop()
        // Release the MediaPlayer resources when the activity is stopped
        mediaPlayer?.release()
        mediaPlayer = null
    }

}