package com.beatstreaming.beat.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.request.SearchRequestEntity;
import com.beatstreaming.core.http.HttpRequestPage;
import com.beatstreaming.media.server.AppServerManager;

import java.net.URI;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SearchPage extends HttpRequestPage<SearchRequestEntity> {
    private SearchPageBinding searchPageBinding;

    @Inject AppServerManager appServerManager;

    public SearchPage() {
        super(SearchRequestEntity.class, Request.Method.GET);
    }

    @Override
    public URI getUri() {
        return this.appServerManager.getAppServer().getUri();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.searchPageBinding.getRoot();
    }
}
