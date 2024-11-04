package com.beatstreaming.beat.bind;

import android.content.Context;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.section.DisplayCarouselSectionContext;
import com.beatstreaming.beat.section.DisplayListSectionContext;
import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.bind.SectionContextRegistryItem;
import com.beatstreaming.core.bind.SectionContextType;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class BeatSectionContextRegistry extends SectionContextRegistry {
    protected final Context context;

    protected final AppTrackListImageItemBinder appTrackListImageItemBinder;
    protected final AppAlbumCardImageItemBinder appAlbumCardImageItemBinder;
    protected final AppArtistCardImageItemBinder appArtistCardImageItemBinder;

    @Inject
    public BeatSectionContextRegistry(Context context, AppTrackListImageItemBinder appTrackListImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder) {
        this.context = context;

        this.appTrackListImageItemBinder = appTrackListImageItemBinder;
        this.appAlbumCardImageItemBinder = appAlbumCardImageItemBinder;
        this.appArtistCardImageItemBinder = appArtistCardImageItemBinder;

        this.list.add(new SectionContextRegistryItem("track", SectionContextType.LIST, TrackEntity[].class, new DisplayListSectionContext(this.context, this.appTrackListImageItemBinder)));
        this.list.add(new SectionContextRegistryItem("album", SectionContextType.CAROUSEL, AlbumEntity[].class, new DisplayCarouselSectionContext(this.context, this.appAlbumCardImageItemBinder)));
        this.list.add(new SectionContextRegistryItem("artist", SectionContextType.CAROUSEL, ArtistEntity[].class, new DisplayCarouselSectionContext(this.context, this.appArtistCardImageItemBinder)));
    }
}
