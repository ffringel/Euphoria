package com.euphoriastream.android;

import android.media.AudioManager;
import android.media.MediaPlayer;

import java.io.IOException;

public class AudioPlayer {

    MediaPlayer mediaPlayer = new MediaPlayer();
    public static AudioPlayer audioPlayer;
    String url = "";

    public AudioPlayer() {
        this.audioPlayer = this;
    }

    public void playStream(String url) {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayer = null;
        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

            mediaPlayer.prepareAsync();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
