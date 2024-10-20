package com.beatstreaming.beat.section;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.core.http.HttpRequestSection;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.databinding.AppSourcePageBinding;
import com.beatstreaming.media.section.AppSourceListSection;
import com.beatstreaming.media.server.AppServer;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.item.TrackListImageItemBinder;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistTrackListSection extends HttpRequestSection<ArtistEntity, AppSourceListSection<AppSourceContext, TrackEntity>, AppSourceContext, ArtistEntity> {
    private final TrackListImageItemBinder trackListImageItemBinder;

    @SneakyThrows
    public ArtistTrackListSection(Context context, AppSourcePageBinding appSourcePageBinding, AppServer appServer, TrackListImageItemBinder trackListImageItemBinder) {
        super(context, appSourcePageBinding.recommendedAppList, new AppSourceListSection<>(context), ArtistEntity.class, Request.Method.GET);

        this.trackListImageItemBinder = trackListImageItemBinder;

        this.load(new URIBuilder(appServer.getUrl()).setPathSegments("api", "v1", "app", "featured").build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.section.getSectionContext().setListRecyclerViewAdapter(new ListRecyclerViewAdapter<AppSourceContext, TrackEntity>(null, artistEntity.getTracks(), this.trackListImageItemBinder));

        super.onLoad(artistEntity);
    }
}