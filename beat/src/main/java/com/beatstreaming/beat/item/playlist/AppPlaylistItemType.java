package com.beatstreaming.beat.item.playlist;

import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.item.PlaylistItemType;

public class AppPlaylistItemType extends PlaylistItemType {
    public AppPlaylistItemType() {
        super(PlaylistEntity.class, AppPlaylistItemBinder.class);
    }
}