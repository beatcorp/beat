package com.beatstreaming.beat.item;

import android.view.LayoutInflater;

import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.MediaImageBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.squareup.picasso.Picasso;

public class TrackListImageItemBinder extends TrackListItemBinder {
    @Override
    public void bind(AppSourceContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaImageBinding mediaImageBinding = MediaImageBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        Picasso.get().load(item.getAlbum().getImage().getUrl()).into(mediaImageBinding.mediaImage);

        this.mediaCover.addView(mediaImageBinding.getRoot());
    }
}
