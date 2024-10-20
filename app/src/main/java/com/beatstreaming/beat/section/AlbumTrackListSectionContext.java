package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

import com.beatstreaming.beat.R;
import com.beatstreaming.beat.item.TrackListIndexItemBinder;
import com.beatstreaming.core.component.ListSectionContext;
import com.beatstreaming.core.component.SectionContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.music.entity.TrackEntity;

public class AlbumTrackListSectionContext extends ListSectionContext<AppSourceContext, TrackEntity> {
    public AlbumTrackListSectionContext(Context context, AppSourceContext appSourceContext, TrackEntity[] entities, TrackListIndexItemBinder binder) {
        super(context, R.string.section_album_track_list_title, new ListRecyclerViewAdapter<AppSourceContext, TrackEntity>(appSourceContext, entities, binder));
    }

    @Override
    public SectionContext<AppSourceContext, TrackEntity> getPageContext() {
        this.listSectionBinding.sectionList.setLayoutManager(new GridLayoutManager(this.context, 2));

        return super.getPageContext();
    }
}
