package com.beatstreaming.beat.item.track;

import android.view.LayoutInflater;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.databinding.MediaCoverTextBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.sheet.track.TrackListSheet;

import lombok.SneakyThrows;

public class AppTrackListIndexItemBinder<T extends ItemEntity> extends AppTrackListItemBinder<SectionPlayerContext, T> {
    public AppTrackListIndexItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        super(player, trackItemType, trackListSheet);
    }

    @Override
    @SneakyThrows
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaCoverTextBinding mediaCoverTextBinding = MediaCoverTextBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        mediaCoverTextBinding.mediaText.setText(String.valueOf(context.getIndex() + 1));

        this.mediaCover.addView(mediaCoverTextBinding.getRoot());
    }
}
