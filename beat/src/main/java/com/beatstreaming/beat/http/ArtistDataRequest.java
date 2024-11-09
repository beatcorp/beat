package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.player.ArtistPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.squareup.picasso.Picasso;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistDataRequest extends HttpRequestBinding<ArtistEntity, ArtistPageBinding, ArtistSectionListBinding> {
    private final AppSourceEntity appSourceEntity;
    private final SectionListBinder sectionListBinder;

    private final ArtistEntity artistEntity;

    @SneakyThrows
    public ArtistDataRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, SectionListBinder sectionListBinder, ArtistEntity artistEntity) {
        super(context, artistPageBinding.artistTrackList, artistPageBinding, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.artistEntity = artistEntity;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.artistEntity.setImage(artistEntity.getImage());

        Picasso.get().load(this.artistEntity.getImage().getUrl()).into(this.pageBinding.artistImage.mediaImage);

        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(new SectionPlayerContext(this.appSourceEntity, new ArtistPlayerSource(artistEntity)), artistEntity.getSections(), this.sectionListBinder));

        super.onLoad(artistEntity);
    }
}