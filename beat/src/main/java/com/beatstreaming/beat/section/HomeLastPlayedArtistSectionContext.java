package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.ArtistItemType;
import com.beatstreaming.music.item.ContextLibraryItemBinder;

import java.util.Arrays;
import java.util.HashSet;

public class HomeLastPlayedArtistSectionContext extends ListSectionContext {
    public HomeLastPlayedArtistSectionContext(Context context, ListContext listContext, ArtistItemType artistItemType, LibraryItemEntity[] libraryItemEntity, ContextLibraryItemBinder contextLibraryItemBinder) {
        super(context, R.string.home_section_last_played_track_title, new ListRecyclerViewAdapter(listContext, new HashSet<>(Arrays.asList(libraryItemEntity))
                .stream()
                .map((item) -> new LibraryItemEntity(item.getAppSourceContext(), artistItemType, new SerializableItemEntity(artistItemType.getClazz(), ((TrackEntity) item.getItem()).getArtist())))
                .toArray(ItemEntity[]::new),
                contextLibraryItemBinder));
    }
}
