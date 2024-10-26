package com.beatstreaming.beat.item;

import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.item.ArtistItemType;

public class AppArtistItemType extends ArtistItemType {
    public AppArtistItemType() {
        super(ArtistEntity.class, AppArtistCardImageItemBinder.class);
    }
}