package com.beatstreaming.beat.search;

import android.content.Context;

import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.core.component.ListSectionContext;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.TrackEntity;

public class SearchTrackSectionContext extends ListSectionContext<AppSourceContext, TrackEntity> {
    public SearchTrackSectionContext(Context context, AppSourceContext appSourceContext, TrackEntity[] entities, TrackListImageItemBinder binder) {
        super(context, R.string.section_search_track_title, new ListRecyclerViewAdapter<AppSourceContext, TrackEntity>(appSourceContext, entities, binder));
    }
}
