package com.beatstreaming.beat.sheet;

import com.beatstreaming.beat.activity.AppAlbumFragmentActivity;
import com.beatstreaming.core.component.sheet.list.ListSheetContext;
import com.beatstreaming.media.player.PlayContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.R;
import com.beatstreaming.music.entity.TrackEntity;

public class GoToAlbumContext extends GoToContext {
    public GoToAlbumContext() {
        super(R.string.sheet_track_view_album, R.drawable.album, AppAlbumFragmentActivity.class);
    }

    @Override
    public Object[] getItems(ListSheetContext<PlayContext, LibraryItemEntity<TrackEntity>> listSheetContext) {
        return new Object[]{listSheetContext.getItem().getAppSourceContext(), listSheetContext.getItem().getItem().getAlbum()};
    }
}
