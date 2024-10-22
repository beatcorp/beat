package com.beatstreaming.beat;

import android.os.Bundle;

import com.beatstreaming.core.MainActivity;
import com.beatstreaming.music.player.ui.TrackPlayerBar;

public class AppMainActivity extends MainActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                .replace(this.mainActivityBinding.footer.getId(), new TrackPlayerBar(mainActivity))
                .addToBackStack(null)
                .commit();
    }
}
