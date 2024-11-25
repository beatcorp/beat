package com.beatstreaming.beat.sheet;

import android.content.Context;

import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.core.component.sheet.list.ListSheetItemContext;
import com.beatstreaming.media.sheet.AppSheet;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;

public class AppContext extends ListSheetItemContext<LibraryItemEntity<TrackEntity>> {
    public AppContext() {
        super(com.beatstreaming.media.R.string.sheet_app_about, com.beatstreaming.core.R.drawable.info);
    }

    @Override
    public void onCall(Context context, ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        new AppSheet(context).setup(listSheetContext.getItem().getAppSourceContext().getContext()).show();
    }

    @Override
    public String getTitle(Context context, ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        return String.format(super.getTitle(context, listSheetContext), listSheetContext.getItem().getAppSourceContext().getContext().getName());
    }
}
