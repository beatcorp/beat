package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.beat.request.SearchResultEntity;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.databinding.SearchPageBinding;
import com.beatstreaming.media.server.AppServer;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestBinding<SearchResultEntity, SearchPageResultBinding> {
    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppServer appServer, SearchPayload searchPayload, SearchPageResultBinding searchPageResultBinding) {
        super(context, searchPageBinding.searchResultList, searchPageResultBinding, SearchResultEntity.class, Request.Method.GET);

        this.load(new URIBuilder(appServer.getUrl()).setPathSegments("api", "v1", "app", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.binding.trackSection.init();

        super.onLoad(searchResultEntity);
    }
}