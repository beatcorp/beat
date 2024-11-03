package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.beatstreaming.beat.http.AlbumDataRequest;
import com.beatstreaming.beat.payload.AlbumPayload;
import com.beatstreaming.beat.section.PlayableSectionListBinder;
import com.beatstreaming.media.list.AppSourceListContext;
import com.beatstreaming.media.databinding.CollectionPageBinding;
import com.beatstreaming.music.databinding.AlbumSectionListBinding;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.page.AlbumPage;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppAlbumPage extends AlbumPage {
    @Inject PlayableSectionListBinder playableSectionListBinder;

    public AppAlbumPage(AppSourceListContext appSourceContext, AlbumEntity albumEntity) {
        super(appSourceContext, albumEntity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.collectionPageBinding = CollectionPageBinding.inflate(this.getLayoutInflater());

        new AlbumDataRequest(layoutInflater.getContext(), this.collectionPageBinding, this.appSourceContext.getItem(), new AlbumPayload(this.imageItemEntity.getId()), AlbumSectionListBinding.inflate(this.getLayoutInflater()), this.playableSectionListBinder);

        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }
}
