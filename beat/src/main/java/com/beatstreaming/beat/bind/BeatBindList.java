package com.beatstreaming.beat.bind;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.bind.BindListItem;
import com.beatstreaming.core.bind.BindType;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class BeatBindList extends BindList {
    private final AppTrackListImageItemBinder appTrackListImageItemBinder;
    private final AppAlbumCardImageItemBinder appAlbumCardImageItemBinder;
    private final AppArtistCardImageItemBinder appArtistCardImageItemBinder;

    @Inject
    public BeatBindList(AppTrackListImageItemBinder appTrackListImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder) {
        this.appTrackListImageItemBinder = appTrackListImageItemBinder;
        this.appAlbumCardImageItemBinder = appAlbumCardImageItemBinder;
        this.appArtistCardImageItemBinder = appArtistCardImageItemBinder;

        this.list.add(new BindListItem("track", BindType.LIST, TrackEntity[].class, this.appTrackListImageItemBinder));
        this.list.add(new BindListItem("album", BindType.CAROUSEL, AlbumEntity[].class, this.appAlbumCardImageItemBinder));
        this.list.add(new BindListItem("artist", BindType.CAROUSEL, ArtistEntity[].class, this.appArtistCardImageItemBinder));
    }
}
