package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.http.ArtistDataRequest;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.databinding.LoadablePageBinding;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.databinding.ItemListBinding;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.page.LoadableArtistPage;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppLoadableArtistPage extends LoadableArtistPage {
    @Inject SectionListBinder sectionListBinder;

    public AppLoadableArtistPage(AppSourceListContext appSourceContext, ArtistEntity artistEntity) {
        super(appSourceContext, artistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.loadablePageBinding = LoadablePageBinding.inflate(this.getLayoutInflater());

        new ArtistDataRequest(layoutInflater.getContext(), this.loadablePageBinding, this.appSourceContext.getItem(), new ArtistPayload(this.artistEntity.getId()), ArtistPageBinding.inflate(this.getLayoutInflater()), ItemListBinding.inflate(this.getLayoutInflater()), this.sectionListBinder, this.artistEntity);

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
