package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.ContextLibraryItemBinder;

import java.util.Arrays;
import java.util.HashSet;

public class HomeLastPlayedArtistSectionContext extends ListSectionContext {
    public HomeLastPlayedArtistSectionContext(Context context, ListContext listContext, LibraryItemEntity[] libraryItemEntity, ContextLibraryItemBinder contextLibraryItemBinder) {
        super(context, R.string.home_section_last_played_track_title, new ListRecyclerViewAdapter(listContext, new HashSet<>(Arrays.asList(libraryItemEntity)).stream().map((item) -> ((TrackEntity) item.getItem()).getArtist()).toArray(ArtistEntity[]::new), contextLibraryItemBinder));
    }
}
