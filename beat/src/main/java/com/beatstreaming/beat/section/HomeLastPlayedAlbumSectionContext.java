package com.beatstreaming.beat.section;

import android.annotation.SuppressLint;
import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.AlbumItemType;
import com.beatstreaming.music.item.ContextLibraryItemBinder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class HomeLastPlayedAlbumSectionContext extends ListSectionContext {
    @SuppressLint("NewApi")
    public HomeLastPlayedAlbumSectionContext(Context context, ListContext listContext, AlbumItemType albumItemType, LibraryItemEntity[] libraryItemEntity, ContextLibraryItemBinder contextLibraryItemBinder) {
        super(context, R.string.home_section_last_played_track_title, new ListRecyclerViewAdapter(listContext, Arrays.stream(libraryItemEntity)
                .map(item -> new LibraryItemEntity(item.getAppSourceContext(), albumItemType, new SerializableItemEntity(albumItemType.getClazz(), ((TrackEntity) item.getItem()).getAlbum())))
                .collect(Collectors.toCollection(HashSet::new))
                .toArray(ItemEntity[]::new),
                contextLibraryItemBinder));
    }
}
