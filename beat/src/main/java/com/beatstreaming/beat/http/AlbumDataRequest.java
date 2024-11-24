package com.beatstreaming.beat.http;

import android.content.Context;

import com.android.volley.Request;
import com.beatstreaming.media.R;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.section.AlbumSectionListBinder;
import com.beatstreaming.core.http.HttpRequestBinding;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.button.StartPlayingButton;
import com.beatstreaming.media.button.StartPlayingContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.media.entity.AppSourceEntity;
import com.beatstreaming.media.player.Player;
import com.beatstreaming.music.databinding.AlbumSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.player.AlbumPlayerSource;
import com.beatstreaming.music.player.SectionPlayerContext;

import org.apache.http.client.utils.URIBuilder;

import lombok.SneakyThrows;

public class AlbumDataRequest extends HttpRequestBinding<AlbumEntity, CollectionPageBinding, AlbumSectionListBinding> {
    private final Player player;
    private final AppSourceEntity appSourceEntity;
    private final AlbumSectionListBinder sectionListBinder;

    @SneakyThrows
    public AlbumDataRequest(Context context, CollectionPageBinding collectionPageBinding, Player player, AppSourceEntity appSourceEntity, AlbumPayload albumPayload, AlbumSectionListBinding albumSectionListBinding, AlbumSectionListBinder sectionListBinder) {
        super(context, collectionPageBinding.collectionList, collectionPageBinding, albumSectionListBinding, AlbumEntity.class, Request.Method.GET);

        this.player = player;
        this.appSourceEntity = appSourceEntity;
        this.sectionListBinder = sectionListBinder;

        this.load(new URIBuilder(appSourceEntity.getUrl()).setPathSegments("api", "v1", "album", albumPayload.getId()).build());
    }

    @Override
    public void onLoad(AlbumEntity albumEntity) {
        SectionPlayerContext sectionPlayerContext = new SectionPlayerContext(this.appSourceEntity, new AlbumPlayerSource(albumEntity));

        this.resultBinding.sectionList.setAdapter(new ListRecyclerViewAdapter(sectionPlayerContext, albumEntity.getSections(), this.sectionListBinder));

        ((StartPlayingButton) this.pageBinding.collectionHeader.findViewById(R.id.start_playing_button)).setup(new StartPlayingContext(albumEntity.getSections(), this.player, sectionPlayerContext));

        super.onLoad(albumEntity);
    }
}