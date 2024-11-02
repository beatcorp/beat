package com.beatstreaming.beat.item.artist;

import android.view.View;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.item.CardImageItemBinder;
import com.beatstreaming.media.player.Player;
import com.beatstreaming.music.entity.ArtistEntity;

import lombok.SneakyThrows;

public class AppArtistCardImageItemBinder extends CardImageItemBinder<ArtistEntity> {
    public AppArtistCardImageItemBinder(Player<ArtistEntity> player) {
        super(player);
    }

    @Override
    public void bind(AppSourceListContext context, ListViewHolder<ArtistEntity> holder, ArtistEntity item) {
        super.bind(context, holder, item);

        this.mediaCoverImageBinding.mediaCard.setRadius(Integer.MAX_VALUE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            @SneakyThrows
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppArtistPage(context, item))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
