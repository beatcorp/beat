package com.beatstreaming.beat.item;

import com.beatstreaming.media.item.AlbumItemType;

public class AppAlbumItemType extends AlbumItemType<AlbumCardImageItemBinder> {
    public AppAlbumItemType() {
        super(AlbumCardImageItemBinder.class);
    }
}