package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.beatstreaming.music.player.SearchPlayerSource;
import com.beatstreaming.music.request.SearchResultEntity;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestBinding<SearchResultEntity, SearchPageBinding, SearchPageResultBinding> {
    private final AppSourceEntity appSourceEntity;
    private final PlayableSectionListBinder sectionListBinder;

    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppSourceEntity appSourceEntity, SearchPayload searchPayload, SearchPageResultBinding searchPageResultBinding, PlayableSectionListBinder sectionListBinder) {
        super(context, searchPageBinding.searchResultList, searchPageBinding, searchPageResultBinding, SearchResultEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(new SectionPlayerContext(this.appSourceEntity, new SearchPlayerSource(searchResultEntity)), searchResultEntity.getSections(), this.sectionListBinder));

        super.onLoad(searchResultEntity);
    }
}