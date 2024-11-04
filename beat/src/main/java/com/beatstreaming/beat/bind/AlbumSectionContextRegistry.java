package com.beatstreaming.beat.bind;

import com.beatstreaming.core.bind.SectionContextRegistryItem;
import com.beatstreaming.core.bind.SectionContextType;
import com.beatstreaming.music.entity.TrackEntity;

import javax.inject.Inject;

public class AlbumSectionContextRegistry extends BeatSectionContextRegistry {
    @Inject
    public AlbumSectionContextRegistry() {
        super();

        this.list.add(new SectionContextRegistryItem("track", SectionContextType.LIST, TrackEntity[].class, this));
    }
}
