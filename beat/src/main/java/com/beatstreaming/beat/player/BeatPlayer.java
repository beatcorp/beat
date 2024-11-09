package com.beatstreaming.beat.player;

import android.content.Context;

import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;

import com.beatstreaming.media.player.Player;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.youtube.player.YouTubePlayerHttpClient;

public class BeatPlayer extends Player<TrackEntity> {
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
