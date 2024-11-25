package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.item.track.AppLibraryPlaylistTrackItemBinder;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.button.StartPlayingContext;
import com.beatstreaming.media.databinding.StartPlayingButtonBinding;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.databinding.ItemListBinding;
import com.beatstreaming.media.player.Player;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.list.PlaylistListContext;
import com.beatstreaming.music.page.PlaylistPage;
import com.beatstreaming.music.player.PlaylistPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;

import java.util.Arrays;
import java.util.Objects;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppPlaylistPage extends PlaylistPage {
    @Inject Player player;
    @Inject TrackItemType trackItemType;
    @Inject AppLibraryPlaylistTrackItemBinder appPlaylistTrackItemBinder;

    public AppPlaylistPage(AppSourceListContext appSourceContext, PlaylistEntity playlistEntity) {
        super(appSourceContext, playlistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.collectionPageBinding = CollectionPageBinding.inflate(this.getLayoutInflater());

        PlaylistListContext playlistListContext = new PlaylistListContext(this.imageItemEntity);
        SectionPlayerContext<TrackEntity> sectionPlayerContext = new SectionPlayerContext(null, new PlaylistPlayerSource(imageItemEntity));
        TrackEntity[] list = Arrays.stream(this.imageItemEntity.getTracks().toArray(new LibraryItemEntity[]{})).filter(Objects::nonNull).map(LibraryItemEntity::getItem).toArray(TrackEntity[]::new);

        ItemListBinding itemListBinding = ItemListBinding.inflate(this.getLayoutInflater());
        itemListBinding.list.setAdapter(new ListRecyclerViewAdapter(playlistListContext, this.imageItemEntity.getTracks().toArray(new LibraryItemEntity[]{}), this.appPlaylistTrackItemBinder));

        this.collectionPageBinding.collectionList.view.addView(itemListBinding.getRoot());

        this.collectionPageBinding.collectionHeader.addView(StartPlayingButtonBinding.inflate(this.getLayoutInflater()).getRoot().setup(new StartPlayingContext(list, this.player, this.trackItemType, sectionPlayerContext)));

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
