package com.beatstreaming.beat.activity;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.activity.FragmentMainActivity;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.entity.ArtistEntity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppArtistFragmentActivity extends FragmentMainActivity {
    public AppArtistFragmentActivity() {
        super(AppArtistPage.class, new Class[]{AppSourceListContext.class, ArtistEntity.class});
    }
}
