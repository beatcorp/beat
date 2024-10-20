package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.http.ArtistTrackListRequest;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.page.AlbumPage;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppAlbumPage extends AlbumPage {
    public AppAlbumPage(AppSourceContext appSourceContext, AlbumEntity albumEntity) {
        super(appSourceContext, albumEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.collectionPageBinding = CollectionPageBinding.inflate(this.getLayoutInflater());

        new ArtistTrackListRequest(layoutInflater.getContext(), artistPageBinding, this.appSourceContext.getAppSourceEntity(), new ArtistPayload(this.artistEntity.getId()), ArtistSectionListBinding.inflate(this.getLayoutInflater()), this.trackListImageItemBinder);

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
