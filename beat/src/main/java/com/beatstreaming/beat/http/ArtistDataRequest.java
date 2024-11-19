package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.databinding.LoadablePageBinding;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.databinding.ItemListBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.player.ArtistPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.squareup.picasso.Picasso;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistDataRequest extends HttpRequestBinding<ArtistEntity, LoadablePageBinding, ArtistPageBinding> {
    private final AppSourceEntity appSourceEntity;
    private final SectionListBinder sectionListBinder;
    private final ItemListBinding itemListBinding;

    @SneakyThrows
    public ArtistDataRequest(Context context, LoadablePageBinding loadablePageBinding, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistPageBinding artistPageBinding, ItemListBinding itemListBinding, SectionListBinder sectionListBinder) {
        super(context, loadablePageBinding.loadResult, loadablePageBinding, artistPageBinding, ArtistEntity.class, Request.Method.GET);

        this.appSourceEntity = appSourceEntity;
        this.itemListBinding = itemListBinding;
        this.sectionListBinder = sectionListBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.resultBinding.artistName.setText(artistEntity.getName());

        Picasso.get().load(artistEntity.getImage().getUrl()).into(this.resultBinding.artistImage.mediaImage);

        this.itemListBinding.list.setAdapter(new ListRecyclerViewAdapter(new SectionPlayerContext(this.appSourceEntity, new ArtistPlayerSource(artistEntity)), artistEntity.getSections(), this.sectionListBinder));
        this.resultBinding.artistTrackList.getRoot().addView(this.itemListBinding.getRoot());

        super.onLoad(artistEntity);
    }
}