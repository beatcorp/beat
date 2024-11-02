package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.beat.section.ArtistTrackListSectionContext;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.player.ArtistPlayerContext;
import com.beatstreaming.music.player.ArtistPlayerSource;
import com.squareup.picasso.Picasso;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistTrackListRequest extends HttpRequestBinding<ArtistEntity, ArtistPageBinding, ArtistSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final AppTrackListImageItemBinder trackListItemBinder;

    @SneakyThrows
    public ArtistTrackListRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, AppTrackListImageItemBinder trackListItemBinder) {
        super(context, artistPageBinding.artistTrackList, artistPageBinding, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.trackListItemBinder = trackListItemBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        Picasso.get().load(artistEntity.getImage().getUrl()).into(this.pageBinding.artistImage.mediaImage);

        this.resultBinding.trackSection.init(new ArtistTrackListSectionContext(this.context, new AppSourceListContext(this.appSourceEntity), artistEntity.getTracks(), (AppTrackListImageItemBinder) this.trackListItemBinder.setup(new ArtistPlayerContext((new AppSourceListContext(this.appSourceEntity)), new ArtistPlayerSource(artistEntity)))));

        super.onLoad(artistEntity);
    }
}