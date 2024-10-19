package com.beatstreaming.beat.page;

import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.R;
import com.beatstreaming.core.pages.Pages;

import lombok.Getter;

@Getter
public enum AppPages implements Pages {
    HOME(R.id.home, new AppHomePage()),
    SEARCH(R.id.search, new AppSearchPage()),
    LIBRARY(R.id.library, new AppLibraryPage());

    private final int layout;
    private final Fragment fragment;

    AppPages(int layout, Fragment fragment) {
        this.layout = layout;
        this.fragment = fragment;
    }
}
