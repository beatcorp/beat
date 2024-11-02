package com.beatstreaming.beat.item.album;

import android.view.View;

import com.beatstreaming.beat.page.AppAlbumPage;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.list.ListViewHolder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.item.CardImageItemBinder;
import com.beatstreaming.music.entity.AlbumEntity;

import lombok.SneakyThrows;

public class AppAlbumCardImageItemBinder extends CardImageItemBinder<AlbumEntity> {
    @Override
    public void bind(AppSourceListContext context, ListViewHolder<AlbumEntity> holder, AlbumEntity item) {
        super.bind(context, holder, item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            @SneakyThrows
            public void onClick(View view) {
                MainActivity.mainActivity.getSupportFragmentManager().beginTransaction()
                        .replace(MainActivity.mainActivity.getMainActivityBinding().fragment.getId(), new AppAlbumPage(context, item))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
