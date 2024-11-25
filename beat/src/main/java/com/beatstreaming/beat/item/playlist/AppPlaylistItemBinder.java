package com.beatstreaming.beat.item.playlist;

import android.view.View;

import com.beatstreaming.beat.page.AppPlaylistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.item.LibraryItemContext;
import com.beatstreaming.media.sheet.LibrarySheetContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.playlist.PlaylistItemBinder;
import com.beatstreaming.music.sheet.playlist.PlaylistListSheet;

import lombok.SneakyThrows;

public class AppPlaylistItemBinder extends PlaylistItemBinder {
    @Override
    public void bind(LibraryItemContext<LibraryItemEntity<TrackEntity>> context, ListViewHolder<PlaylistEntity> holder, PlaylistEntity item) {
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
                new PlaylistListSheet(view.getContext()).setup(new LibrarySheetContext(null, null, context.getLibraryItemEntity())).show();

                return true;
            }
        });
    }
}