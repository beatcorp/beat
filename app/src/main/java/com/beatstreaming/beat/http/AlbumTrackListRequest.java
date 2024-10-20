package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.search.SearchTrackSectionContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class AlbumTrackListRequest extends HttpRequestBinding<AlbumEntity, ArtistSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final TrackListImageItemBinder trackListItemBinder;

    @SneakyThrows
    public AlbumTrackListRequest(Context context, CollectionPageBinding collectionPageBinding, AppSourceEntity appSourceEntity, AlbumPayload albumPayload, ArtistSectionListBinding artistSectionListBinding, TrackListImageItemBinder trackListItemBinder) {
        super(context, collectionPageBinding.collectionList, artistSectionListBinding, AlbumEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListItemBinder = trackListItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "album").addParameter("id", albumPayload.getId()).build());
    }

    @Override
    public void onLoad(AlbumEntity albumEntity) {
        this.binding.trackSection.init(new SearchTrackSectionContext(this.context, new AppSourceContext(this.appSourceEntity), albumEntity.getTracks(), this.trackListItemBinder));

        super.onLoad(albumEntity);
    }
}