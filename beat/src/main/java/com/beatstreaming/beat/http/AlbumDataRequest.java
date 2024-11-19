package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.section.AlbumSectionListBinder;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.AlbumSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.player.AlbumPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class AlbumDataRequest extends HttpRequestBinding<AlbumEntity, CollectionPageBinding, AlbumSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final AlbumSectionListBinder sectionListBinder;

    @SneakyThrows
    public AlbumDataRequest(Context context, CollectionPageBinding collectionPageBinding, AppSourceEntity appSourceEntity, AlbumPayload albumPayload, AlbumSectionListBinding albumSectionListBinding, AlbumSectionListBinder sectionListBinder) {
        super(context, collectionPageBinding.collectionList, collectionPageBinding, albumSectionListBinding, AlbumEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "album", albumPayload.getId()).build());
    }

    @Override
    public void onLoad(AlbumEntity albumEntity) {
        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(new SectionPlayerContext(this.appSourceEntity, new AlbumPlayerSource(albumEntity)), albumEntity.getSections(), this.sectionListBinder));

        super.onLoad(albumEntity);
    }
}