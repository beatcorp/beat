package com.beatstreaming.beat.section;

import com.beatstreaming.core.bind.BindList;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SectionEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.SearchPlayerContext;
import com.beatstreaming.music.request.SearchResultEntity;
import com.google.gson.Gson;

public class SearchSectionListBinder extends SectionListBinder<SearchPlayerContext, MediaListItemBinder<SearchPlayerContext, TrackEntity, SearchResultEntity>> {
    public SearchSectionListBinder(Gson gson, BindList bindList) {
        super(gson, bindList);
    }

    @Override
    public void bind(SearchPlayerContext context, ListViewHolder<SectionEntity<? extends ItemEntity>> holder, SectionEntity<? extends ItemEntity> item) {
        super.bind(context, holder, item);

        if (this.bindListItem == null) {
            return;
        }

        this.bindListItem.getBinder().setup(context);
    }
}
