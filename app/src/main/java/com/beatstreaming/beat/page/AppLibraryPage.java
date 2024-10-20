package com.beatstreaming.beat.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.beatstreaming.beat.databinding.LibraryPageBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AppLibraryPage extends Fragment {
    private LibraryPageBinding libraryPageBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.libraryPageBinding = LibraryPageBinding.inflate(this.getLayoutInflater());

        return this.libraryPageBinding.getRoot();
    }
}
