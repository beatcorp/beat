package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beatstreaming.core.bind.SectionContextItemContext;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.core.list.ListContext;

public class DisplayCarouselSectionContext extends SectionContextItemContext<ListContext, ItemEntity> {
    public DisplayCarouselSectionContext(Context context, ListBinder binder) {
        super(context, new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false), binder);
    }
}
