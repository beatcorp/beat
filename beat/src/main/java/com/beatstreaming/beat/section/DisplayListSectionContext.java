package com.beatstreaming.beat.section;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.beatstreaming.core.bind.SectionContextItemContext;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListBinder;
import com.beatstreaming.core.list.ListContext;

public class DisplayListSectionContext extends SectionContextItemContext<ListContext, ItemEntity> {
    public DisplayListSectionContext(Context context, ListBinder binder) {
        super(context, new LinearLayoutManager(context), binder);
    }
}
