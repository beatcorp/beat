package com.beatstreaming.beat.bind;

import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.bind.BindListItem;
import com.beatstreaming.core.bind.BindType;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class BeatBindList extends BindList {
    private final AppTrackListImageItemBinder appTrackListImageItemBinder;

    @Inject
    public BeatBindList(AppTrackListImageItemBinder appTrackListImageItemBinder) {
        this.appTrackListImageItemBinder = appTrackListImageItemBinder;

        this.list.add(new BindListItem("track", BindType.LIST, TrackEntity[].class, this.appTrackListImageItemBinder));
    }
}
