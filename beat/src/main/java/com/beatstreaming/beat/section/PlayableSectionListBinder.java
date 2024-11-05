package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.google.gson.Gson;

public class PlayableSectionListBinder extends SectionListBinder<SectionPlayerContext, MediaListItemBinder> {
    public PlayableSectionListBinder(Gson gson, SectionContextRegistry sectionContextRegistry) {
        super(gson, sectionContextRegistry);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<SectionEntity<ItemEntity>> holder, SectionEntity<ItemEntity> item) {
        ListBinder listBinder = this.list.getBinder(item.getId(), item.getType()).getContext().getBinder();

        if (listBinder instanceof MediaListItemBinder) {
            ((MediaListItemBinder) listBinder).setup(context);
        }

        super.bind(context, holder, item);
    }
}
