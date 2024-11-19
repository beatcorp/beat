package com.beatstreaming.beat.item.album;

import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.item.AlbumItemType;

public class AppAlbumItemType extends AlbumItemType {
    public AppAlbumItemType() {
        super(AlbumEntity.class, AppAlbumListImageItemBinder.class);
    }
}