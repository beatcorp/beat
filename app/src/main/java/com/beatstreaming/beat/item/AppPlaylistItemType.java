package com.beatstreaming.beat.item;

import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.playlist.PlaylistItemBinder;

public class AppPlaylistItemType extends PlaylistItemType {
    public AppPlaylistItemType() {
        super(PlaylistEntity.class, PlaylistItemBinder.class);
    }
}