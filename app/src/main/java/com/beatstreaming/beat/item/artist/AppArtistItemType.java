package com.beatstreaming.beat.item.artist;

import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.item.ArtistItemType;

public class AppArtistItemType extends ArtistItemType {
    public AppArtistItemType() {
        super(ArtistEntity.class, AppArtistListImageItemBinder.class);
    }
}