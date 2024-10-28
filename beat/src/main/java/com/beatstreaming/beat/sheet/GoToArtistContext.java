package com.beatstreaming.beat.sheet;

import com.beatstreaming.beat.activity.AppArtistFragmentActivity;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.TrackEntity;

public class GoToArtistContext extends GoToContext {
    public GoToArtistContext() {
        super(R.string.sheet_track_view_artist, R.drawable.artist, AppArtistFragmentActivity.class);
    }

    @Override
    public Object[] getItems(ListSheetContext<LibraryItemEntity<TrackEntity>> listSheetContext) {
        return new Object[]{listSheetContext.getItem().getAppSourceContext(), listSheetContext.getItem().getItem().getArtist()};
    }
}
