package com.beatstreaming.beat.sheet;

import android.content.Context;

import androidx.annotation.NonNull;

import com.beatstreaming.music.sheet.track.AddToPlaylistListContext;
import com.beatstreaming.music.sheet.track.TrackListSheet;

public class AppTrackListSheet extends TrackListSheet {
    public AppTrackListSheet(@NonNull Context context) {
        super(context);

        this.init(context);
    }

    public AppTrackListSheet(@NonNull Context context, int theme) {
        super(context, theme);

        this.init(context);
    }

    protected AppTrackListSheet(@NonNull Context context, boolean cancelable, OnCancelListener onCancelListener) {
        super(context, cancelable, onCancelListener);

        this.init(context);
    }

    @Override
    public void init(Context context) {
        super.init(context);

        this.list.add(new GoToArtistContext());
    }
}
