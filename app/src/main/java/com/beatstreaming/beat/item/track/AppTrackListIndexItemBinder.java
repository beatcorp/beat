package com.beatstreaming.beat.item.track;

import android.view.LayoutInflater;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.databinding.MediaCoverTextBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.entity.cast.AlbumTrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.list.AlbumListContext;
import com.beatstreaming.music.player.MusicPlayer;
import com.google.gson.Gson;

import lombok.SneakyThrows;

public class AppTrackListIndexItemBinder<T extends ItemEntity> extends AppTrackListItemBinder<AlbumListContext, T> {
    public AppTrackListIndexItemBinder(MusicPlayer player, TrackItemType trackItemType) {
        super(player, trackItemType);
    }

    @Override
    @SneakyThrows
    public void bind(AlbumListContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        AlbumTrackEntity albumTrackEntity = new Gson().fromJson(new Gson().toJson(item), AlbumTrackEntity.class);

        albumTrackEntity.setup(context.getAlbumEntity());

        super.bind(context, holder, albumTrackEntity);

        MediaCoverTextBinding mediaCoverTextBinding = MediaCoverTextBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        mediaCoverTextBinding.mediaText.setText(String.valueOf(context.getIndex() + 1));

        this.mediaCover.addView(mediaCoverTextBinding.getRoot());
    }
}
