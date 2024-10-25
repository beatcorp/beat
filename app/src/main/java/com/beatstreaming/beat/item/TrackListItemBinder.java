package com.beatstreaming.beat.item;

import android.view.View;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.entity.NameItemEntity;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.sheet.TrackListSheet;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class TrackListItemBinder<T extends ItemEntity> extends MediaListItemBinder<TrackEntity, T> {
    private final TrackListSheet trackListSheet;

    @Inject
    public TrackListItemBinder(MusicPlayer player, TrackListSheet trackListSheet) {
        super(player);

        this.trackListSheet = trackListSheet;
    }

    @Override
    public void bind(AppSourceContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        this.mediaTitle.setText(item.getName());
        this.mediaSubtitle.setText(Arrays.stream(item.getArtists())
                .map(NameItemEntity::getName)
                .collect(Collectors.joining(", ")));

        this.mediaSubtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppArtistPage(context, item.getArtist()))
                        .addToBackStack(null)
                        .commit();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                trackListSheet.setup(item).show();

                return true;
            }
        });
    }
}
