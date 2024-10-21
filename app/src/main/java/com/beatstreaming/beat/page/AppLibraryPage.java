package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.databinding.LibraryPageBinding;
import com.beatstreaming.core.list.ListRecyclerViewAdapter;
import com.beatstreaming.media.AppSourceContext;
import com.beatstreaming.media.storage.library.LibraryItemEntity;
import com.beatstreaming.media.storage.library.LibraryListStorage;
import com.beatstreaming.media.storage.library.LibraryListStorageManager;
import com.beatstreaming.music.item.AbstractLibraryItemBinder;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppLibraryPage extends Fragment {
    private LibraryPageBinding libraryPageBinding;

    @Inject LibraryListStorageManager libraryListStorageManager;
    @Inject AbstractLibraryItemBinder abstractLibraryItemBinder;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.libraryPageBinding = LibraryPageBinding.inflate(this.getLayoutInflater());

        LibraryListStorage libraryListStorage = this.libraryListStorageManager.load(this.getContext());

        this.libraryPageBinding.libraryList.setAdapter(new ListRecyclerViewAdapter<AppSourceContext, LibraryItemEntity<?>>(null, libraryListStorage.list.toArray(new LibraryItemEntity[]{}), this.abstractLibraryItemBinder));

        return this.libraryPageBinding.getRoot();
    }
}
