package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.beatstreaming.beat.item.AlbumCardImageItemBinder;
import com.beatstreaming.core.component.list.ListSectionContext;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.AlbumEntity;

public class SearchAlbumListSectionContext extends ListSectionContext<AppSourceListContext, AlbumEntity> {
    public SearchAlbumListSectionContext(Context context, AppSourceListContext appSourceContext, AlbumEntity[] entities, AlbumCardImageItemBinder binder) {
        super(context, R.string.section_search_album_title, new ListRecyclerViewAdapter<AppSourceListContext, AlbumEntity>(appSourceContext, entities, binder));
    }

    @Override
    public void onBind() {
        this.listSectionBinding.sectionList.setLayoutManager(new LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false));
    }
}
