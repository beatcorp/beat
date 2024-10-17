package com.beatstreaming.beat;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.beatstreaming.media.page.AppSourcePage;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        this.startActivity(new Intent(this, AppSourcePage.class));
    }
}
