package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.beat.section.ArtistTrackListSectionContext;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.squareup.picasso.Picasso;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistTrackListRequest extends HttpRequestBinding<ArtistEntity, ArtistPageBinding, ArtistSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final TrackListImageItemBinder trackListItemBinder;

    @SneakyThrows
    public ArtistTrackListRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, TrackListImageItemBinder trackListItemBinder) {
        super(context, artistPageBinding.artistTrackList, artistPageBinding, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListItemBinder = trackListItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        Picasso.get().load(artistEntity.getImage().getUrl()).into(this.pageBinding.artistImage.mediaImage);

        this.resultBinding.trackSection.init(new ArtistTrackListSectionContext(this.context, new AppSourceContext(this.appSourceEntity), artistEntity.getTracks(), this.trackListItemBinder));

        super.onLoad(artistEntity);
    }
}