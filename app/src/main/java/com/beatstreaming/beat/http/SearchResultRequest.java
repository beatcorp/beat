package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.item.AlbumCardImageItemBinder;
import com.beatstreaming.beat.item.ArtistCardImageItemBinder;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.beat.request.SearchResultEntity;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.beat.search.SearchAlbumsSectionContext;
import com.beatstreaming.beat.search.SearchArtistsSectionContext;
import com.beatstreaming.beat.search.SearchTrackSectionContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestBinding<SearchResultEntity, SearchPageResultBinding> {
    private final AppSourceEntity appSourceEntity;

    private final TrackListImageItemBinder trackListItemBinder;
    private final ArtistCardImageItemBinder artistCardItemBinder;
    private final AlbumCardImageItemBinder albumCardItemBinder;

    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppSourceEntity appSourceEntity, SearchPayload searchPayload, SearchPageResultBinding searchPageResultBinding, TrackListImageItemBinder trackListItemBinder, ArtistCardImageItemBinder artistCardItemBinder, AlbumCardImageItemBinder albumCardItemBinder) {
        super(context, searchPageBinding.searchResultList, searchPageResultBinding, SearchResultEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;

        this.trackListItemBinder = trackListItemBinder;
        this.artistCardItemBinder = artistCardItemBinder;
        this.albumCardItemBinder = albumCardItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.binding.trackSection.init(new SearchTrackSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getTracks(), this.trackListItemBinder));
        this.binding.albumSection.init(new SearchArtistsSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getArtists(), this.artistCardItemBinder));
        this.binding.artistSection.init(new SearchAlbumsSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getAlbums(), this.albumCardItemBinder));

        super.onLoad(searchResultEntity);
    }
}