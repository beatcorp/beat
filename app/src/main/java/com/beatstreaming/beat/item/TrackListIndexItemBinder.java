package com.beatstreaming.beat.item;

import android.view.LayoutInflater;

import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.MediaCoverTextBinding;
import com.beatstreaming.music.entity.TrackEntity;

public class TrackListIndexItemBinder extends TrackListItemBinder {
    @Override
    public void bind(AppSourceContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaCoverTextBinding mediaCoverTextBinding = MediaCoverTextBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        mediaCoverTextBinding.mediaText.setText(String.valueOf(context.getIndex() + 1));

        this.mediaCover.addView(mediaCoverTextBinding.getRoot());
    }
}
