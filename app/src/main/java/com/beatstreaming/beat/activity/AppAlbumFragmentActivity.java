package com.beatstreaming.beat.activity;

import com.beatstreaming.beat.page.AppAlbumPage;
import com.beatstreaming.core.activity.FragmentMainActivity;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.entity.AlbumEntity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppAlbumFragmentActivity extends FragmentMainActivity {
    public AppAlbumFragmentActivity() {
        super(AppAlbumPage.class, new Class[]{AppSourceListContext.class, AlbumEntity.class});
    }
}
