package com.beatstreaming.beat.item.track;

import android.content.Context;
import android.view.View;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.entity.SerializableItemEntity;
import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.entity.NameItemEntity;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.sheet.track.TrackListSheet;

import java.util.Arrays;
import java.util.stream.Collectors;

import lombok.SneakyThrows;

public class AppTrackListItemBinder<T extends ListContext, V extends ItemEntity> extends MediaListItemBinder<T, TrackEntity, V> {
    protected final TrackItemType trackItemType;
    protected final Class<? extends TrackListSheet> trackListSheet;

    public AppTrackListItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        super(player);

        this.trackItemType = trackItemType;
        this.trackListSheet = trackListSheet;
    }

    @Override
    public void bind(T context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        this.mediaTitle.setText(item.getName());
        this.mediaSubtitle.setText(Arrays.stream(item.getArtists())
                .map(NameItemEntity::getName)
                .collect(Collectors.joining(", ")));

        this.mediaSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppArtistPage((AppSourceListContext) context, item.getArtist()))
                        .addToBackStack(null)
                        .commit();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            @SneakyThrows
            public boolean onLongClick(View view) {
                trackListSheet.getConstructor(Context.class).newInstance(holder.itemView.getContext()).setup(new LibraryItemEntity<TrackEntity>((AppSourceListContext) context, trackItemType, new SerializableItemEntity<>(TrackEntity.class, item))).show();

                return true;
            }
        });
    }
}
