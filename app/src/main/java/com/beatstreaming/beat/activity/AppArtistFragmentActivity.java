package com.beatstreaming.beat.activity;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.activity.SerializableFragmentMainActivity;
import com.beatstreaming.music.entity.ArtistEntity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistFragmentActivity extends SerializableFragmentMainActivity<ArtistEntity> {
    public AppArtistFragmentActivity() {
        super(AppArtistPage.class, ArtistEntity.class);
    }
}
