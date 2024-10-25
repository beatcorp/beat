package com.beatstreaming.beat.item;

import android.view.LayoutInflater;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.MediaCoverImageBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.sheet.TrackListSheet;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class TrackListImageItemBinder<T extends ItemEntity> extends TrackListItemBinder<T> {
    @Inject
    public TrackListImageItemBinder(MusicPlayer player, TrackListSheet trackListSheet) {
        super(player, trackListSheet);
    }

    @Override
    public void bind(AppSourceContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaCoverImageBinding mediaCoverImageBinding = MediaCoverImageBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        Picasso.get().load(item.getAlbum().getImage().getUrl()).into(mediaCoverImageBinding.mediaImage);

        this.mediaCover.addView(mediaCoverImageBinding.getRoot());
    }
}
