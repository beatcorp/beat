package com.beatstreaming.beat.section;

import com.beatstreaming.beat.bind.AlbumSectionContextRegistry;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.ItemListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.request.SearchResultEntity;
import com.google.gson.Gson;

public class AlbumSectionListBinder extends SectionListBinder<SectionPlayerContext, ItemListItemBinder<SectionPlayerContext, SearchResultEntity>, TrackEntity> {
    public AlbumSectionListBinder(Gson gson, AlbumSectionContextRegistry sectionContextRegistry) {
        super(gson, sectionContextRegistry);
    }
}
