package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.ItemListItemBinder;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.request.SearchResultEntity;
import com.google.gson.Gson;

public class PlayableSectionListBinder extends SectionListBinder<SectionPlayerContext, ItemListItemBinder<SectionPlayerContext, SearchResultEntity>> {
    public PlayableSectionListBinder(Gson gson, BindList bindList) {
        super(gson, bindList);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<SectionEntity<? extends ItemEntity>> holder, SectionEntity<? extends ItemEntity> item) {
        super.bind(context, holder, item);

        if (this.bindListItem.getBinder() instanceof MediaListItemBinder) {
            ((MediaListItemBinder) this.bindListItem.getBinder()).setup(context);
        }
    }
}
