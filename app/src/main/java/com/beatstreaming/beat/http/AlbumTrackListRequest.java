package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.section.AlbumTrackListSectionContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.AlbumSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.player.AlbumPlayerContext;
import com.beatstreaming.music.player.AlbumPlayerSource;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class AlbumTrackListRequest extends HttpRequestBinding<AlbumEntity, CollectionPageBinding, AlbumSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final AppTrackListIndexItemBinder<AlbumEntity> trackListIndexItemBinder;

    @SneakyThrows
    public AlbumTrackListRequest(Context context, CollectionPageBinding collectionPageBinding, AppSourceEntity appSourceEntity, AlbumPayload albumPayload, AlbumSectionListBinding albumSectionListBinding, AppTrackListIndexItemBinder trackListIndexItemBinder) {
        super(context, collectionPageBinding.collectionList, collectionPageBinding, albumSectionListBinding, AlbumEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListIndexItemBinder = trackListIndexItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "album").addParameter("id", albumPayload.getId()).build());
    }

    @Override
    public void onLoad(AlbumEntity albumEntity) {
        this.resultBinding.trackSection.init(new AlbumTrackListSectionContext(this.context, new AppSourceListContext(this.appSourceEntity), albumEntity.getTracks(), (AppTrackListIndexItemBinder) this.trackListIndexItemBinder.setup(new AlbumPlayerContext((new AppSourceListContext(this.appSourceEntity)), new AlbumPlayerSource(albumEntity)))));

        super.onLoad(albumEntity);
    }
}