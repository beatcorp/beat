package com.beatstreaming.beat.bind;

import android.content.Context;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;

import javax.inject.Inject;

public class AlbumSectionContextRegistry extends BeatSectionContextRegistry {
    @Inject
    public AlbumSectionContextRegistry(Context context, AppTrackListIndexItemBinder appTrackListIndexItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder) {
        super(context, appTrackListIndexItemBinder, appAlbumCardImageItemBinder, appArtistCardImageItemBinder);
    }
}
