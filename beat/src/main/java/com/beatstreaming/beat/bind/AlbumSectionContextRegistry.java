package com.beatstreaming.beat.bind;

import android.content.Context;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;
import com.beatstreaming.beat.section.DisplayListSectionContext;
import com.beatstreaming.core.bind.SectionContextRegistryItem;
import com.beatstreaming.core.bind.SectionContextType;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class AlbumSectionContextRegistry extends BeatSectionContextRegistry {
    protected final AppTrackListIndexItemBinder appTrackListIndexItemBinder;

    @Inject
    public AlbumSectionContextRegistry(Context context, AppTrackListImageItemBinder appTrackListImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder, AppTrackListIndexItemBinder appTrackListIndexItemBinder) {
        super(context, appTrackListImageItemBinder, appAlbumCardImageItemBinder, appArtistCardImageItemBinder);

        this.appTrackListIndexItemBinder = appTrackListIndexItemBinder;
    }

    @Override
    public void init(Context context) {
        this.list.add(new SectionContextRegistryItem("track", SectionContextType.LIST, TrackEntity[].class, new DisplayListSectionContext(this.context, this.appTrackListIndexItemBinder)));
    }
}
