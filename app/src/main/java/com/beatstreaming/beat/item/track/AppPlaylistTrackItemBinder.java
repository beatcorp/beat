package com.beatstreaming.beat.item.track;

import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class AppPlaylistTrackItemBinder extends ListBinder<ListContext, LibraryItemEntity<TrackEntity>> {
    private final AppTrackListImageItemBinder appTrackListImageItemBinder;

    @Inject
    public AppPlaylistTrackItemBinder(AppTrackListImageItemBinder appTrackListImageItemBinder) {
        this.appTrackListImageItemBinder = appTrackListImageItemBinder;
    }

    @Override
    public void bind(ListContext context, ListViewHolder<LibraryItemEntity<TrackEntity>> holder, LibraryItemEntity<TrackEntity> item) {
        super.bind(context, holder, item);

        this.appTrackListImageItemBinder.bind(item.getAppSourceContext(), holder, item.getItem());
    }

    @Override
    public int getItemLayout() {
        return com.beatstreaming.media.R.layout.media_list_item_binder;
    }
}
