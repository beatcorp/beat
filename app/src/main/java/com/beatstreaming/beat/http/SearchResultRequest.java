package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.beat.request.SearchResultEntity;
import com.beatstreaming.core.component.ItemListSection;
import com.beatstreaming.core.http.HttpRequestSection;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.item.TrackListItemBinder;
import com.beatstreaming.music.search.SearchTrackSectionContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestSection<SearchResultEntity, ItemListSection<AppSourceContext, SearchResultEntity>, AppSourceContext, SearchResultEntity> {
    private final AppSourceEntity appSourceEntity;
    private final TrackListItemBinder trackListItemBinder;

    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppSourceEntity appSourceEntity, SearchPayload searchPayload, TrackListItemBinder trackListItemBinder) {
        super(context, searchPageBinding.searchResultList, new ItemListSection<AppSourceContext, SearchResultEntity>(context), SearchResultEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListItemBinder = trackListItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.binding.trackSection.init(new SearchTrackSectionContext(new AppSourceContext(this.appSourceEntity), searchResultEntity.getTracks(), this.trackListItemBinder));

        super.onLoad(searchResultEntity);
    }
}