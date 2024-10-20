package com.beatstreaming.beat.item;

import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.entity.NameItemEntity;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TrackListItemBinder extends MediaListItemBinder<TrackEntity> {
    @Override
    public void bind(AppSourceContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        this.mediaTitle.setText(item.getName());
        this.mediaSubtitle.setText(Arrays.stream(item.getArtists())
                .map(NameItemEntity::getName)
                .collect(Collectors.joining(", ")));
    }
}
