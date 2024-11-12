package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.item.ContextLibraryItemBinder;

public class HomeLastPlayedTrackSectionContext extends ListSectionContext {
    public HomeLastPlayedTrackSectionContext(Context context, ListContext listContext, LibraryItemEntity[] libraryItemEntity, ContextLibraryItemBinder contextLibraryItemBinder) {
        super(context, R.string.home_section_last_played_track_title, new ListRecyclerViewAdapter(listContext, libraryItemEntity, contextLibraryItemBinder));
    }
}
