package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.beatstreaming.beat.item.AppArtistCardImageItemBinder;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.ArtistEntity;

public class SearchArtistListSectionContext extends ListSectionContext<AppSourceListContext, ArtistEntity> {
    public SearchArtistListSectionContext(Context context, AppSourceListContext appSourceContext, ArtistEntity[] entities, AppArtistCardImageItemBinder binder) {
        super(context, R.string.section_search_artist_title, new ListRecyclerViewAdapter<AppSourceListContext, ArtistEntity>(appSourceContext, entities, binder));
    }

    @Override
    public void onBind() {
        this.listSectionBinding.sectionList.setLayoutManager(new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false));
    }
}