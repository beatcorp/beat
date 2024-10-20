package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.beat.search.SearchTrackSectionContext;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistTrackListRequest extends HttpRequestBinding<ArtistEntity, ArtistSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final TrackListImageItemBinder trackListItemBinder;

    @SneakyThrows
    public ArtistTrackListRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, TrackListImageItemBinder trackListItemBinder) {
        super(context, artistPageBinding.artistTrackList, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListItemBinder = trackListItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.binding.trackSection.init(new SearchTrackSectionContext(this.context, new AppSourceContext(this.appSourceEntity), artistEntity.getTracks(), this.trackListItemBinder));

        super.onLoad(artistEntity);
    }
}