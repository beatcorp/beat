package com.beatstreaming.beat.sheet;

import android.content.Context;

import androidx.annotation.NonNull;

import com.beatstreaming.media.player.PlayContext;
import com.beatstreaming.media.sheet.MediaSheetContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.sheet.playlist.PlaylistListSheet;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.sheet.playlist.RemovePlaylistContext;

public class AppPlaylistListSheet extends PlaylistListSheet<MediaSheetContext<PlayContext, LibraryItemEntity<PlaylistEntity>>> {
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
    public AppPlaylistListSheet setup(MediaSheetContext<PlayContext, LibraryItemEntity<PlaylistEntity>> item) {
        super.setup(item);

        this.list.add(new RemovePlaylistContext(item));

        return this;
    }
}
