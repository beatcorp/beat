package com.beatstreaming.beat;

import android.os.Bundle;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.media.MediaMainActivity;
import com.beatstreaming.media.player.ui.PlayerBar;
import com.beatstreaming.media.service.AppSourceService;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppMainActivity extends MediaMainActivity {
    @Inject AppSourceService appSourceService;

    @Inject PlayerBar<?> playerBar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.appSourceService.start();

        MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(this.mainActivityBinding.footer.getId(), this.playerBar)
                .addToBackStack(null)
                .commit();
    }
}
