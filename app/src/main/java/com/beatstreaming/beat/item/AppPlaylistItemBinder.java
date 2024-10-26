package com.beatstreaming.beat.item;

import android.view.View;

import com.beatstreaming.beat.page.AppPlaylistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.item.playlist.PlaylistItemBinder;
import com.beatstreaming.music.list.TrackListContext;

public class AppPlaylistItemBinder extends PlaylistItemBinder {
    @Override
    public void bind(TrackListContext context, ListViewHolder<LibraryItemEntity<PlaylistEntity>> holder, LibraryItemEntity<PlaylistEntity> item) {
        super.bind(context, holder, item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppPlaylistPage(null, item.getItem()))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}