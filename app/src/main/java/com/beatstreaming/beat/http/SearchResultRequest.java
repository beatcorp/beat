package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.beat.request.SearchResultEntity;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.item.AlbumCardItemBinder;
import com.beatstreaming.music.item.ArtistCardItemBinder;
import com.beatstreaming.music.item.TrackListItemBinder;
import com.beatstreaming.music.search.SearchAlbumsSectionContext;
import com.beatstreaming.music.search.SearchArtistsSectionContext;
import com.beatstreaming.music.search.SearchTrackSectionContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestBinding<SearchResultEntity, SearchPageResultBinding> {
    private final AppSourceEntity appSourceEntity;

    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppSourceEntity appSourceEntity, SearchPayload searchPayload, SearchPageResultBinding searchPageResultBinding) {
        super(context, searchPageBinding.searchResultList, searchPageResultBinding, SearchResultEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.binding.trackSection.init(new SearchTrackSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getTracks(), new TrackListItemBinder()));
        this.binding.albumSection.init(new SearchArtistsSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getArtists(), new ArtistCardItemBinder()));
        this.binding.artistSection.init(new SearchAlbumsSectionContext(this.context, new AppSourceContext(this.appSourceEntity), searchResultEntity.getAlbums(), new AlbumCardItemBinder()));

        super.onLoad(searchResultEntity);
    }
}