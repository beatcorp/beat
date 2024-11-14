package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.http.SearchResultRequest;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.storage.app.AppSourceStorageItem;
import com.beatstreaming.media.storage.app.AppSourceStorageManager;
import com.google.android.material.search.SearchView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppSearchPage extends Fragment {
    private SearchPageBinding searchPageBinding;

    @Inject AppSourceStorageManager appSourceStorageManager;

    @Inject SectionListBinder sectionListBinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.searchPageBinding = SearchPageBinding.inflate(this.getLayoutInflater());

        AppSourceStorageItem appSourceStorageItem = this.appSourceStorageManager.load(this.getContext());

        SearchView searchView = this.searchPageBinding.getRoot().findViewById(com.beatstreaming.core.R.id.search_view);
        searchView.setupWithSearchBar(this.searchPageBinding.searchBar);

        searchView.getEditText().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                searchPageBinding.searchBar.setText(searchView.getText());
                searchView.hide();

                new SearchResultRequest(getLayoutInflater().getContext(), searchPageBinding, appSourceStorageItem.getAppSourceEntity(), SearchPayload.builder().query(searchView.getText().toString()).build(), SearchPageResultBinding.inflate(getLayoutInflater()), sectionListBinder);

                return true;
            }
        });

        return this.searchPageBinding.getRoot();
    }
}
