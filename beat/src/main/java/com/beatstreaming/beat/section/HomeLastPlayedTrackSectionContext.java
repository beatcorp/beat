package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.item.AbstractLibraryItemBinder;

public class HomeLastPlayedTrackSectionContext extends ListSectionContext {
    public HomeLastPlayedTrackSectionContext(Context context, LibraryItemEntity[] libraryItemEntity, AbstractLibraryItemBinder abstractLibraryItemBinder) {
        super(context, R.string.home_section_last_played_track_title, new ListRecyclerViewAdapter(null, libraryItemEntity, abstractLibraryItemBinder));
    }
}
