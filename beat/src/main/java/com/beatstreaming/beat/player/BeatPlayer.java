package com.beatstreaming.beat.player;

import android.content.Context;

import androidx.annotation.OptIn;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;

import com.beatstreaming.media.player.PlayerContext;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.youtube.player.MusicYouTubePlayerInterceptor;

import okhttp3.OkHttpClient;

public class BeatPlayer extends MusicPlayer {
    public BeatPlayer(Context context, PlayerContext playerContext) {
        super(context, playerContext);
    }

    @OptIn(markerClass = UnstableApi.class)
    @Override
    public void onInit() {
        this.player = new ExoPlayer.Builder(this.context)
                .setMediaSourceFactory(new DefaultMediaSourceFactory(new OkHttpDataSource.Factory(new OkHttpClient.Builder().addInterceptor(new MusicYouTubePlayerInterceptor()).build())))
                .setLoadControl(new DefaultLoadControl.Builder()
                        .setBufferDurationsMs(
                                500,
                                1000,
                                250,
                                500
                        ).build())
                .setAudioAttributes(new AudioAttributes.Builder()
                        .setUsage(C.USAGE_MEDIA)
                        .setContentType(C.AUDIO_CONTENT_TYPE_MUSIC)
                        .build(), true)
                .build();

        super.onInit();
    }
}
