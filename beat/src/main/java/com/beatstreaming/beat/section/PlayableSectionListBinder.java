package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.google.gson.Gson;

public class PlayableSectionListBinder extends SectionListBinder<SectionPlayerContext, MediaListItemBinder, TrackEntity> {
    public PlayableSectionListBinder(Gson gson, SectionContextRegistry sectionContextRegistry) {
        super(gson, sectionContextRegistry);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<SectionEntity<TrackEntity>> holder, SectionEntity<TrackEntity> item) {
        context.getPlayerSource().init(item.getTyped(TrackEntity[].class));

        super.bind(context, holder, item);
    }
}
