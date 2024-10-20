package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.page.ArtistPage;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistPage extends ArtistPage {
    public AppArtistPage(AppSourceContext appSourceContext, ArtistEntity artistEntity) {
        super(appSourceContext, artistEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.artistPageBinding = ArtistPageBinding.inflate(this.getLayoutInflater());



        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
