package com.beatstreaming.beat.item;

import android.view.View;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.entity.NameItemEntity;
import com.beatstreaming.media.list.MediaListItemBinder;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.MusicPlayer;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TrackListItemBinder extends MediaListItemBinder<TrackEntity> {
    public TrackListItemBinder(MusicPlayer player) {
        super(player);
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
    }
}
