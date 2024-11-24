package com.beatstreaming.beat.sheet;

import android.content.Context;

import androidx.annotation.NonNull;

import com.beatstreaming.music.sheet.track.PlaylistTrackListSheet;

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
    }
}
