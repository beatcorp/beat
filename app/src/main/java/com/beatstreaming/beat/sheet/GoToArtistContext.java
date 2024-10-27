package com.beatstreaming.beat.sheet;

import android.content.Context;

import com.beatstreaming.beat.activity.AppArtistFragmentActivity;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.core.component.sheet.list.ListSheetItemContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.TrackEntity;

public class GoToArtistContext extends ListSheetItemContext<LibraryItemEntity<TrackEntity>> {
    public GoToArtistContext() {
        super(R.string.sheet_track_view_artist, R.drawable.artist);
    }

    @Override
    public void onCall(Context context, ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        new AppArtistFragmentActivity(listSheetContext.getItem().getAppSourceContext(), listSheetContext.getItem().getItem().getArtist());
    }
}
