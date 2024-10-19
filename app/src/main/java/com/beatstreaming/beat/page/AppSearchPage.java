package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.databinding.SearchPageBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppSearchPage extends Fragment {
    private SearchPageBinding searchPageBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.searchPageBinding.getRoot();
    }
}
