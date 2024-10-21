package com.beatstreaming.beat.item;

import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.item.AlbumItemType;
import com.beatstreaming.music.entity.AlbumEntity;

public class AppAlbumItemType extends AlbumItemType {
    public AppAlbumItemType() {
        super(AlbumCardImageItemBinder.class);
    }
}