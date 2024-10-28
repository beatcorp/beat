package com.beatstreaming.beat.item.artist;

import android.view.View;

import com.beatstreaming.beat.page.AppArtistPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.item.ListImageItemBinder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.music.entity.ArtistEntity;

import lombok.SneakyThrows;

public class AppArtistListImageItemBinder extends ListImageItemBinder<ArtistEntity> {
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
