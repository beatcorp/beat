package com.beatstreaming.beat.item;

import com.beatstreaming.media.storage.library.ItemType;

public class AlbumItemType implements ItemType<AlbumCardImageItemBinder> {
    @Override
    public Class<AlbumCardImageItemBinder> getBinder() {
        return AlbumCardImageItemBinder.class;
    }
}
