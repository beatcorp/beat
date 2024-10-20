package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.http.ArtistTrackListRequest;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.storage.AppSourceStorageItem;
import com.beatstreaming.media.storage.AppSourceStorageManager;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.page.ArtistPage;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistPage extends ArtistPage {
    @Inject AppSourceStorageManager appSourceStorageManager;
    @Inject TrackListImageItemBinder trackListImageItemBinder;

    public AppArtistPage(AppSourceContext appSourceContext, ArtistEntity artistEntity) {
        super(appSourceContext, artistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.artistPageBinding = ArtistPageBinding.inflate(this.getLayoutInflater());

        AppSourceStorageItem appSourceStorageItem = this.appSourceStorageManager.load(layoutInflater.getContext());

        new ArtistTrackListRequest(layoutInflater.getContext(), artistPageBinding, appSourceStorageItem.getAppSourceEntity(), new ArtistPayload(this.artistEntity.getId()), ArtistSectionListBinding.inflate(this.getLayoutInflater()), this.trackListImageItemBinder);

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
