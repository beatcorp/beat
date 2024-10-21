package com.beatstreaming.beat.item;

import com.beatstreaming.core.list.ListBinder;

import lombok.Getter;

@Getter
public enum AppItemType {
    TRACK(TrackListItemBinder.class),
    ARTIST(ArtistCardImageItemBinder.class),
    ALBUM(AlbumCardImageItemBinder.class);

    private final Class<? extends ListBinder<?, ?>> binder;

    AppItemType(Class<? extends ListBinder<?, ?>> binder) {
        this.binder = binder;
    }
}
