package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.databinding.HomePageBinding;
import com.beatstreaming.beat.section.HomeLastPlayedTrackSectionContext;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.music.item.AbstractLibraryItemBinder;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppHomePage extends HomePage {
    private HomePageBinding homePageBinding;

    @Inject AbstractLibraryItemBinder abstractLibraryItemBinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.homePageBinding = HomePageBinding.inflate(this.getLayoutInflater());

        this.homePageBinding.trackSection.init(new HomeLastPlayedTrackSectionContext(null, null, abstractLibraryItemBinder));

        return this.homePageBinding.getRoot();
    }
}
 