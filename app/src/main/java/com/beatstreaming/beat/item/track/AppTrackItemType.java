package com.beatstreaming.beat.item.track;

import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;

public class AppTrackItemType extends TrackItemType {
    public AppTrackItemType() {
        super(TrackEntity.class, AppPlaylistTrackItemBinder.class);
    }
}