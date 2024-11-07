package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.item.track.AppPlaylistTrackItemBinder;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.databinding.ItemListBinding;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.list.PlaylistListContext;
import com.beatstreaming.music.page.PlaylistPage;
import com.beatstreaming.music.player.PlaylistPlayerSource;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppPlaylistPage extends PlaylistPage {
    @Inject AppPlaylistTrackItemBinder appPlaylistTrackItemBinder;

    public AppPlaylistPage(AppSourceListContext appSourceContext, PlaylistEntity playlistEntity) {
        super(appSourceContext, playlistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.collectionPageBinding = CollectionPageBinding.inflate(this.getLayoutInflater());

        ItemListBinding itemListBinding = ItemListBinding.inflate(this.getLayoutInflater());
        itemListBinding.list.setAdapter(new ListRecyclerViewAdapter(new PlaylistListContext(this.appSourceContext.getItem(), new PlaylistPlayerSource(this.imageItemEntity)), this.imageItemEntity.getTracks().toArray(new LibraryItemEntity[]{}), this.appPlaylistTrackItemBinder));

        this.collectionPageBinding.collectionList.view.addView(itemListBinding.getRoot());

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
