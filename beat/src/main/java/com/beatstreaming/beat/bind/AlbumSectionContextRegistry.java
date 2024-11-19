package com.beatstreaming.beat.bind;

import android.content.Context;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.album.AppAlbumListImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistListImageItemBinder;
import com.beatstreaming.beat.item.track.AppAlbumTrackItemBinder;

import javax.inject.Inject;

public class AlbumSectionContextRegistry extends BeatSectionContextRegistry {
    @Inject
    public AlbumSectionContextRegistry(Context context, AppAlbumTrackItemBinder appTrackListIndexItemBinder, AppArtistListImageItemBinder appArtistListImageItemBinder, AppAlbumListImageItemBinder appAlbumListImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder) {
        super(context, appTrackListIndexItemBinder, appArtistListImageItemBinder, appAlbumListImageItemBinder, appArtistCardImageItemBinder, appAlbumCardImageItemBinder);
    }
}
