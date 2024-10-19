package com.beatstreaming.beat.page;

import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.R;

public enum Pages {
    HOME(R.id.home, new AppHomePage()),
    SEARCH(R.id.search, new AppSearchPage()),
    LIBRARY(R.id.library, new AppLibraryPage());

    public final int layout;
    public final Fragment fragment;

    Pages(int layout, Fragment fragment) {
        this.layout = layout;
        this.fragment = fragment;
    }
}
