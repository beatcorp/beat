package com.beatstreaming.beat.item.playlist;

import android.content.Context;
import android.view.View;

import com.beatstreaming.beat.page.AppPlaylistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.sheet.MediaSheetContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.playlist.PlaylistItemBinder;
import com.beatstreaming.music.list.TrackListContext;
import com.beatstreaming.music.sheet.playlist.PlaylistListSheet;

import lombok.SneakyThrows;

public class AppPlaylistItemBinder extends PlaylistItemBinder {
    private final PlaylistItemType playlistItemType;
    private final Class<? extends PlaylistListSheet> playlistListSheet;

    public AppPlaylistItemBinder(PlaylistItemType playlistItemType, Class<? extends PlaylistListSheet> playlistListSheet) {
        this.playlistItemType = playlistItemType;
        this.playlistListSheet = playlistListSheet;
    }

    @Override
    public void bind(TrackListContext context, ListViewHolder<PlaylistEntity> holder, PlaylistEntity item) {
        super.bind(context, holder, item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppPlaylistPage(null, item))
                        .addToBackStack(null)
                        .commit();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            @SneakyThrows
            public boolean onLongClick(View view) {
                playlistListSheet.getConstructor(Context.class).newInstance(holder.itemView.getContext()).setup(new MediaSheetContext(null, new LibraryItemEntity<PlaylistEntity>(null, playlistItemType, new SerializableItemEntity<>(PlaylistEntity.class, item)))).show();

                return true;
            }
        });
    }
}