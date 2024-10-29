package com.beatstreaming.beat;

import android.os.Bundle;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.media.MediaMainActivity;
import com.beatstreaming.media.player.ui.PlayerBar;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppMainActivity extends MediaMainActivity {
    @Inject PlayerBar<?> playerBar;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(this.mainActivityBinding.footer.getId(), this.playerBar)
                .addToBackStack(null)
                .commit();
    }
}
