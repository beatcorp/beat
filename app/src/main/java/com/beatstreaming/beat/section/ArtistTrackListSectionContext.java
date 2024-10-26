package com.beatstreaming.beat.section;

import android.content.Context;

import com.beatstreaming.beat.R;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.component.section.SectionContext;
import com.beatstreaming.core.layout.ListGridLayoutManager;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.entity.TrackEntity;

public class ArtistTrackListSectionContext extends ListSectionContext<AppSourceListContext, TrackEntity> {
    public ArtistTrackListSectionContext(Context context, AppSourceListContext appSourceContext, TrackEntity[] entities, AppTrackListImageItemBinder binder) {
        super(context, R.string.section_artist_track_list_title, new ListRecyclerViewAdapter<AppSourceListContext, TrackEntity>(appSourceContext, entities, binder));
    }

    @Override
    public SectionContext<AppSourceListContext, TrackEntity> getPageContext() {
        this.listSectionBinding.sectionList.setLayoutManager(new ListGridLayoutManager(this.context));

        return super.getPageContext();
    }
}
