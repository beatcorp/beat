package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.beat.payload.ArtistPayload;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.core.list.SectionListBinder;
import com.beatstreaming.media.button.StartPlayingButton;
import com.beatstreaming.media.button.StartPlayingContext;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.media.player.Player;
import com.beatstreaming.music.databinding.ArtistPageBinding;
import com.beatstreaming.music.databinding.ArtistSectionListBinding;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.player.ArtistPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;
import com.squareup.picasso.Picasso;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class ArtistSectionDataRequest extends HttpRequestBinding<ArtistEntity, ArtistPageBinding, ArtistSectionListBinding> {
    private final Player player;
    private final TrackItemType trackItemType;
    private final AppSourceEntity appSourceEntity;
    private final SectionListBinder sectionListBinder;

    private final ArtistEntity artistEntity;

    @SneakyThrows
    public ArtistSectionDataRequest(Context context, ArtistPageBinding artistPageBinding, Player player, TrackItemType trackItemType, AppSourceEntity appSourceEntity, ArtistPayload artistPayload, ArtistSectionListBinding artistSectionListBinding, SectionListBinder sectionListBinder, ArtistEntity artistEntity) {
        super(context, artistPageBinding.artistTrackList, artistPageBinding, artistSectionListBinding, ArtistEntity.class, Request.Method.GET);

        this.player = player;
        this.trackItemType = trackItemType;
        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.artistEntity = artistEntity;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "artist", artistPayload.getId()).build());
    }

    @Override
    public void onLoad(ArtistEntity artistEntity) {
        this.pageBinding.artistName.setText(this.artistEntity.getName());
        Picasso.get().load(this.artistEntity.getImage().getUrl()).into(this.pageBinding.artistImage.mediaImage);

        SectionPlayerContext sectionPlayerContext = new SectionPlayerContext(this.appSourceEntity, new ArtistPlayerSource(artistEntity));

        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(sectionPlayerContext, artistEntity.getSections(), this.sectionListBinder));

        ((StartPlayingButton) this.pageBinding.collectionHeader.findViewById(com.beatstreaming.media.R.id.start_playing_button)).setup(new StartPlayingContext(artistEntity.getSections(), this.player, this.trackItemType, sectionPlayerContext));

        super.onLoad(artistEntity);
    }
}