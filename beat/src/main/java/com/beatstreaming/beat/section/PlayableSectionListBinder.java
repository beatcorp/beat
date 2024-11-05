package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.ItemListItemBinder;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.request.SearchResultEntity;
import com.google.gson.Gson;

public class PlayableSectionListBinder extends SectionListBinder<SectionPlayerContext, ItemListItemBinder<SectionPlayerContext, SearchResultEntity>> {
    public PlayableSectionListBinder(Gson gson, SectionContextRegistry sectionContextRegistry) {
        super(gson, sectionContextRegistry);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<SectionEntity<? extends ItemEntity>> holder, SectionEntity<? extends ItemEntity> item) {
        context.getPlayerSource().init(item.getList());

        super.bind(context, holder, item);
    }
}
