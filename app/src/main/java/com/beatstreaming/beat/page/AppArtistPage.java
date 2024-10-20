package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.databinding.ArtistPageBinding;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.music.entity.ArtistEntity;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistPage extends HomePage {
    private ArtistPageBinding artistPageBinding;

    private final AppSourceContext appSourceContext;
    private final ArtistEntity artistEntity;

    public AppArtistPage(AppSourceContext appSourceContext, ArtistEntity artistEntity) {
        this.appSourceContext = appSourceContext;
        this.artistEntity = artistEntity;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.artistPageBinding = ArtistPageBinding.inflate(this.getLayoutInflater());

        this.artistPageBinding.artistName.setText(this.artistEntity.getName());

        Picasso.get().load(this.artistEntity.getImage().getUrl()).into(this.artistPageBinding.artistImage.trackImage);

        return this.artistPageBinding.getRoot();
    }
}
