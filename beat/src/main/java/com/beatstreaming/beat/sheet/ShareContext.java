package com.beatstreaming.beat.sheet;

import android.content.Context;

import com.beatstreaming.media.player.PlayContext;
import com.beatstreaming.music.R;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.core.component.sheet.list.ListSheetItemContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.sheet.share.AppShareListSheet;

public class ShareContext extends ListSheetItemContext<PlayContext, LibraryItemEntity<TrackEntity>> {
    public ShareContext() {
        super(R.string.sheet_track_share, com.beatstreaming.media.R.drawable.share);
    }

    @Override
    public void onCall(Context context, ListSheetContext<PlayContext, LibraryItemEntity<TrackEntity>> listSheetContext) {
        new AppShareListSheet(context).setup(listSheetContext.getItem()).show();
    }
}
