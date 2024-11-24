package com.beatstreaming.beat.item.track;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;

public class AppPlaylistTrackItemBinder<T extends ItemEntity> extends AppTrackListImageItemBinder<T> {
    public AppPlaylistTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class trackListSheet, Class loadableArtistPage) {
        super(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);
    }
}
