package com.beatstreaming.beat.item.track;

import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.sheet.track.TrackListSheet;

public class AppAlbumTrackItemBinder extends AppTrackListIndexItemBinder<SectionPlayerContext, TrackEntity> {
    public AppAlbumTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        super(player, trackItemType, trackListSheet);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        item.setAlbum((AlbumEntity) context.getPlayerSource().getItem());

        super.bind(context, holder, item);
    }
}
