package com.beatstreaming.beat.item.track;

import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class AppPlaylistTrackItemBinder extends ListBinder<ListContext, LibraryItemEntity<TrackEntity>> {
    private final AppTrackListItemBinder appTrackListItemBinder;

    @Inject
    public AppPlaylistTrackItemBinder(AppTrackListItemBinder appTrackListItemBinder) {
        this.appTrackListItemBinder = appTrackListItemBinder;
    }

    @Override
    public void bind(ListContext context, ListViewHolder<LibraryItemEntity<TrackEntity>> holder, LibraryItemEntity<TrackEntity> item) {
        super.bind(context, holder, item);

        this.appTrackListItemBinder.bind(item.getAppSourceContext(), holder, item.getItem());
    }
}
