package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.http.ArtistDataRequest;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.page.ArtistPage;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistPage extends ArtistPage {
    @Inject SectionListBinder sectionListBinder;

    public AppArtistPage(AppSourceListContext appSourceContext, ArtistEntity artistEntity) {
        super(appSourceContext, artistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.artistPageBinding = ArtistPageBinding.inflate(this.getLayoutInflater());

        new ArtistDataRequest(layoutInflater.getContext(), this.artistPageBinding, this.appSourceContext.getItem(), new ArtistPayload(this.artistEntity.getId()), ArtistSectionListBinding.inflate(this.getLayoutInflater()), this.sectionListBinder, this.artistEntity);

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
