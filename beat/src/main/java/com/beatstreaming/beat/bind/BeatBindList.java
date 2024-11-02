package com.beatstreaming.beat.bind;

import com.beatstreaming.beat.item.track.AppTrackListItemBinder;
import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.bind.BindListItem;
import com.beatstreaming.core.bind.BindType;

import javax.inject.Inject;

public class BeatBindList extends BindList {
    private final AppTrackListItemBinder appTrackListItemBinder;

    @Inject
    public BeatBindList(AppTrackListItemBinder appTrackListItemBinder) {
        this.appTrackListItemBinder = appTrackListItemBinder;

        this.list.add(new BindListItem("track", BindType.LIST, this.appTrackListItemBinder));
    }
}
