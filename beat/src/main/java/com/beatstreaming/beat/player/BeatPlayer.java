package com.beatstreaming.beat.player;

import android.content.Context;

import com.beatstreaming.media.player.Player;
import com.beatstreaming.music.entity.TrackEntity;

public class BeatPlayer extends Player<TrackEntity> {
    public BeatPlayer(Context context) {
        super(context);
    }

    @Override
    public void onInit() {
        super.onInit();
    }
}
