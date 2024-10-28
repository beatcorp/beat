package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.TrackEntity;

public class SearchTrackListSectionContext extends ListSectionContext<AppSourceListContext, TrackEntity> {
    public SearchTrackListSectionContext(Context context, AppSourceListContext appSourceContext, TrackEntity[] entities, AppTrackListImageItemBinder binder) {
        super(context, R.string.section_search_track_title, new ListRecyclerViewAdapter<AppSourceListContext, TrackEntity>(appSourceContext, entities, binder));
    }
}
