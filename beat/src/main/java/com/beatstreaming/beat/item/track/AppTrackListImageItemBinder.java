package com.beatstreaming.beat.item.track;

import android.view.LayoutInflater;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.databinding.MediaCoverImageBinding;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.page.LoadableArtistPage;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.sheet.track.TrackListSheet;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class AppTrackListImageItemBinder<T extends ItemEntity> extends AppTrackListItemBinder<SectionPlayerContext, T> {
    @Inject
    public AppTrackListImageItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage) {
        super(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Override
    public void bind(SectionPlayerContext context, ListViewHolder<TrackEntity> holder, TrackEntity item) {
        super.bind(context, holder, item);

        MediaCoverImageBinding mediaCoverImageBinding = MediaCoverImageBinding.inflate(LayoutInflater.from(this.mediaCover.getContext()));
        Picasso.get().load(item.getAlbum().getImage().getUrl()).into(mediaCoverImageBinding.mediaImage);

        this.mediaCover.addView(mediaCoverImageBinding.getRoot());
    }
}
