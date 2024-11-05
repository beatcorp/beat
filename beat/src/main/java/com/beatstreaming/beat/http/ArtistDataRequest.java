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

    @SneakyThrows
    public ArtistDataRequest(Context context, ArtistPageBinding artistPageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, SectionListBinder sectionListBinder) {
        super(context, artistPageBinding.artistTrackList, artistPageBinding, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist").addParameter("id", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        Picasso.get().load(artistEntity.getImage().getUrl()).into(this.pageBinding.artistImage.mediaImage);

        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(new SectionPlayerContext(this.appSourceEntity, new ArtistPlayerSource(artistEntity)), artistEntity.getSections(), this.sectionListBinder));

        super.onLoad(artistEntity);
    }
}