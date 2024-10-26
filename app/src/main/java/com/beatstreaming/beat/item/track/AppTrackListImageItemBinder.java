package com.beatstreaming.beat.item.track;

import android.view.LayoutInflater;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.databinding.MediaCoverImageBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.MusicPlayer;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class AppTrackListImageItemBinder<T extends ItemEntity> extends AppTrackListItemBinder<AppSourceListContext, T> {
    @Inject
    public AppTrackListImageItemBinder(MusicPlayer player, TrackItemType trackItemType) {
        super(player, trackItemType);
    }

    @Override
    public void bind(AppSourceListContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaCoverImageBinding mediaCoverImageBinding = MediaCoverImageBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        Picasso.get().load(item.getAlbum().getImage().getUrl()).into(mediaCoverImageBinding.mediaImage);

        this.mediaCover.addView(mediaCoverImageBinding.getRoot());
    }
}
