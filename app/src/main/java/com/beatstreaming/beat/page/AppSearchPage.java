package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.http.SearchResultRequest;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.media.databinding.SearchPageBinding;
import com.beatstreaming.media.storage.AppSourceStorageItem;
import com.beatstreaming.media.storage.AppSourceStorageManager;
import com.beatstreaming.music.item.TrackListItemBinder;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppSearchPage extends Fragment {
    private SearchPageBinding searchPageBinding;

    @Inject AppSourceStorageManager appSourceStorageManager;
    @Inject TrackListItemBinder trackListItemBinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.searchPageBinding = SearchPageBinding.inflate(this.getLayoutInflater());

        AppSourceStorageItem appSourceStorageItem = this.appSourceStorageManager.load(this.getContext());

        new SearchResultRequest(this.getContext(), this.searchPageBinding, appSourceStorageItem.getAppSourceEntity(), SearchPayload.builder().query("la casa azul").build(), SearchPageResultBinding.inflate(this.getLayoutInflater()), this.trackListItemBinder);

        return this.searchPageBinding.getRoot();
    }
}
