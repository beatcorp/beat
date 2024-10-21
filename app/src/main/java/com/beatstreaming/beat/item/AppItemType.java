package com.beatstreaming.beat.item;

import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.media.storage.library.ItemType;

import lombok.Getter;

@Getter
public enum AppItemType implements ItemType {
    TRACK(TrackListItemBinder.class),
    ARTIST(ArtistCardImageItemBinder.class),
    ALBUM(AlbumCardImageItemBinder.class);

    private final Class<? extends ListBinder<?, ?>> binder;

    AppItemType(Class<? extends ListBinder<?, ?>> binder) {
        this.binder = binder;
    }
}
