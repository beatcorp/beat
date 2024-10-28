package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.databinding.SearchPageBinding;
import com.beatstreaming.beat.databinding.SearchPageResultBinding;
import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.payload.SearchPayload;
import com.beatstreaming.music.player.SearchPlayerContext;
import com.beatstreaming.music.player.SearchPlayerSource;
import com.beatstreaming.music.request.SearchResultEntity;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.beat.section.SearchAlbumListSectionContext;
import com.beatstreaming.beat.section.SearchArtistListSectionContext;
import com.beatstreaming.beat.section.SearchTrackListSectionContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class SearchResultRequest extends HttpRequestBinding<SearchResultEntity, SearchPageBinding, SearchPageResultBinding> {
    private final AppSourceEntity appSourceEntity;

    private final AppTrackListImageItemBinder trackListItemBinder;
    private final AppArtistCardImageItemBinder artistCardItemBinder;
    private final AppAlbumCardImageItemBinder albumCardItemBinder;

    @SneakyThrows
    public SearchResultRequest(Context context, SearchPageBinding searchPageBinding, AppSourceEntity appSourceEntity, SearchPayload searchPayload, SearchPageResultBinding searchPageResultBinding, AppTrackListImageItemBinder trackListItemBinder, AppArtistCardImageItemBinder artistCardItemBinder, AppAlbumCardImageItemBinder albumCardItemBinder) {
        super(context, searchPageBinding.searchResultList, searchPageBinding, searchPageResultBinding, SearchResultEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;

        this.trackListItemBinder = trackListItemBinder;
        this.artistCardItemBinder = artistCardItemBinder;
        this.albumCardItemBinder = albumCardItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "search").addParameter("query", searchPayload.getQuery()).build());
    }

    @Override
    public void onLoad(SearchResultEntity searchResultEntity) {
        this.resultBinding.trackSection.init(new SearchTrackListSectionContext(this.context, new AppSourceListContext(this.appSourceEntity), searchResultEntity.getTracks(), (AppTrackListImageItemBinder) this.trackListItemBinder.setup(new SearchPlayerContext((new AppSourceListContext(this.appSourceEntity)), new SearchPlayerSource(searchResultEntity)))));
        this.resultBinding.albumSection.init(new SearchArtistListSectionContext(this.context, new AppSourceListContext(this.appSourceEntity), searchResultEntity.getArtists(), this.artistCardItemBinder));
        this.resultBinding.artistSection.init(new SearchAlbumListSectionContext(this.context, new AppSourceListContext(this.appSourceEntity), searchResultEntity.getAlbums(), this.albumCardItemBinder));

        super.onLoad(searchResultEntity);
    }
}