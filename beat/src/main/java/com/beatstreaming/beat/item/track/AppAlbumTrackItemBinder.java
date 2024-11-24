package com.beatstreaming.beat.item.track;

import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.page.LoadableArtistPage;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.sheet.track.TrackListSheet;

public class AppAlbumTrackItemBinder extends AppTrackListIndexItemBinder<TrackEntity> {
    public AppAlbumTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage) {
        super(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);
    }
}
