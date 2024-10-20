package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.TrackListIndexItemBinder;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.section.AlbumTrackListSectionContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.AlbumSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class AlbumTrackListRequest extends HttpRequestBinding<AlbumEntity, AlbumSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final TrackListIndexItemBinder trackListIndexItemBinder;

    @SneakyThrows
    public AlbumTrackListRequest(Context context, CollectionPageBinding collectionPageBinding, AppSourceEntity appSourceEntity, AlbumPayload albumPayload, AlbumSectionListBinding albumSectionListBinding, TrackListIndexItemBinder trackListIndexItemBinder) {
        super(context, collectionPageBinding.collectionList, albumSectionListBinding, AlbumEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListIndexItemBinder = trackListIndexItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "album").addParameter("id", albumPayload.getId()).build());
    }

    @Override
    public void onLoad(AlbumEntity albumEntity) {
        this.binding.trackSection.init(new AlbumTrackListSectionContext(this.context, new AppSourceContext(this.appSourceEntity), albumEntity.getTracks(), this.trackListIndexItemBinder));

        super.onLoad(albumEntity);
    }
}