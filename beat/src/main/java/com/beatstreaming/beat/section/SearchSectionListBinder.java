package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.google.gson.Gson;

public class SearchSectionListBinder extends SectionListBinder<SectionPlayerContext, MediaListItemBinder<SectionPlayerContext, ?, SectionEntity<? extends ItemEntity>>> {
    public SearchSectionListBinder(Gson gson, BindList bindList) {
        super(gson, bindList);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<SectionEntity<? extends ItemEntity>> holder, SectionEntity<? extends ItemEntity> item) {
        super.bind(context, holder, item);

        this.bindListItem.getBinder().setup(context.getPlayerContext());
    }
}
