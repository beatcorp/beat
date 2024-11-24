package com.beatstreaming.beat.item.track;

import android.content.Context;
import android.view.View;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.sheet.MediaSheetContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;

import lombok.SneakyThrows;

public class AppPlaylistTrackItemBinder<T extends ItemEntity> extends AppTrackListImageItemBinder<T> {
    public AppPlaylistTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class trackListSheet, Class loadableArtistPage) {
        super(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            @SneakyThrows
            public boolean onLongClick(View view) {
                trackListSheet.getConstructor(Context.class).newInstance(holder.itemView.getContext()).setup(new MediaSheetContext(null, new LibraryItemEntity<TrackEntity>(context, trackItemType, new SerializableItemEntity<>(TrackEntity.class, item)))).show();

                return true;
            }
        });
    }
}
