package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.item.TrackListIndexItemBinder;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.databinding.ItemListBinding;
import com.beatstreaming.music.entity.PlaylistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.page.PlaylistPage;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppPlaylistPage extends PlaylistPage {
    @Inject TrackListIndexItemBinder trackListImageItemBinder;

    public AppPlaylistPage(AppSourceContext appSourceContext, PlaylistEntity playlistEntity) {
        super(appSourceContext, playlistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.collectionPageBinding = CollectionPageBinding.inflate(this.getLayoutInflater());

        ItemListBinding itemListBinding = ItemListBinding.inflate(this.getLayoutInflater());
        itemListBinding.list.setAdapter(new ListRecyclerViewAdapter(null, imageItemEntity.getTracks().toArray(new TrackEntity[0]), this.trackListImageItemBinder));

        this.collectionPageBinding.collectionList.view.addView(itemListBinding.getRoot());

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
