package com.beatstreaming.beat.sheet;

import android.content.Context;

import androidx.annotation.NonNull;

import com.beatstreaming.media.sheet.LibrarySheetContext;
import com.beatstreaming.music.sheet.playlist.PlaylistListSheet;
import com.beatstreaming.music.entity.PlaylistEntity;

public class AppPlaylistListSheet extends PlaylistListSheet<LibrarySheetContext<PlaylistEntity>> {
    public AppPlaylistListSheet(@NonNull Context context) {
        super(context);

        this.init(context);
    }

    public AppPlaylistListSheet(@NonNull Context context, int theme) {
        super(context, theme);

        this.init(context);
    }

    public AppPlaylistListSheet(@NonNull Context context, boolean cancelable, OnCancelListener onCancelListener) {
        super(context, cancelable, onCancelListener);

        this.init(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);
    }


    @Override
    public AppPlaylistListSheet setup(LibrarySheetContext<PlaylistEntity> item) {
        super.setup(item);

        return this;
    }
}
