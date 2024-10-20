package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.http.HttpRequestSection;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.AppSourcePageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.section.ArtistTrackListSection;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistTrackListRequest extends HttpRequestSection<ArtistEntity, ArtistTrackListSection, AppSourceContext, TrackEntity> {
    private final TrackListImageItemBinder trackListImageItemBinder;

    @SneakyThrows
    public ArtistTrackListRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, TrackListImageItemBinder trackListImageItemBinder) {
        super(context, artistPageBinding.artistTracksList, new ArtistTrackListSection(context), ArtistEntity.class, Request.Method.GET);

        this.trackListImageItemBinder = trackListImageItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.section.getSectionContext().setListRecyclerViewAdapter(new ListRecyclerViewAdapter<AppSourceContext, TrackEntity>(null, artistEntity.getTracks(), this.trackListImageItemBinder));

        super.onLoad(artistEntity);
    }
}