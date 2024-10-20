package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

import com.beatstreaming.beat.R;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.core.component.ListSectionContext;
import com.beatstreaming.core.component.SectionContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.music.entity.TrackEntity;

public class ArtistTrackListSectionContext extends ListSectionContext<AppSourceContext, TrackEntity> {
    public ArtistTrackListSectionContext(Context context, AppSourceContext appSourceContext, TrackEntity[] entities, TrackListImageItemBinder binder) {
        super(context, R.string.section_artist_track_list_title, new ListRecyclerViewAdapter<AppSourceContext, TrackEntity>(appSourceContext, entities, binder));
    }

    @Override
    public SectionContext<AppSourceContext, TrackEntity> getPageContext() {
        this.listSectionBinding.sectionList.setLayoutManager(new GridLayoutManager(this.context, 2));

        return super.getPageContext();
    }
}
