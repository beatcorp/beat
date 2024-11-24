package com.beatstreaming.beat.sheet;

import android.content.Context;

import androidx.annotation.NonNull;

import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.sheet.track.PlaylistTrackListSheet;
import com.beatstreaming.music.sheet.track.RemoveFromPlaylistContext;

public class AppPlaylistTrackListSheet extends PlaylistTrackListSheet {
    public AppPlaylistTrackListSheet(@NonNull Context context) {
        super(context);

        this.init(context);
    }

    public AppPlaylistTrackListSheet(@NonNull Context context, int theme) {
        super(context, theme);

        this.init(context);
    }

    public AppPlaylistTrackListSheet(@NonNull Context context, boolean cancelable, OnCancelListener onCancelListener) {
        super(context, cancelable, onCancelListener);

        this.init(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);

        this.list.add(new RemoveFromPlaylistContext((PlaylistEntity) this.listSheetContext.getItem().getContext()));

        this.list.add(new GoToArtistContext());
        this.list.add(new GoToAlbumContext());
        this.list.add(new ShareContext());
        this.list.add(new AppContext());
    }
}
