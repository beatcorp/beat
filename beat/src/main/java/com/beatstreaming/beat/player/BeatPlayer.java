package com.beatstreaming.beat.player;

import android.content.Context;

import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;

import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.youtube.player.YouTubePlayerHttpClient;

public class BeatPlayer extends MusicPlayer {
    public BeatPlayer(Context context) {
        super(context);
    }

    @Override
    public void onInit() {
        this.player = new ExoPlayer.Builder(this.context)
                .setMediaSourceFactory(new DefaultMediaSourceFactory(new OkHttpDataSource.Factory(new YouTubePlayerHttpClient())))
                .build();

        super.onInit();
    }
}
