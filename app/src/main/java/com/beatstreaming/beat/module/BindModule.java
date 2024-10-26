package com.beatstreaming.beat.module;

import com.beatstreaming.beat.item.AlbumCardImageItemBinder;
import com.beatstreaming.beat.item.AppAlbumItemType;
import com.beatstreaming.beat.item.AppArtistItemType;
import com.beatstreaming.beat.item.AppPlaylistItemType;
import com.beatstreaming.beat.item.ArtistCardImageItemBinder;
import com.beatstreaming.beat.item.TrackListImageItemBinder;
import com.beatstreaming.beat.item.TrackListIndexItemBinder;
import com.beatstreaming.beat.page.AppHomePage;
import com.beatstreaming.beat.page.AppPages;
import com.beatstreaming.beat.server.DefaultAppServerManager;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.beatstreaming.media.server.AppServerManager;
import com.beatstreaming.music.item.AlbumItemType;
import com.beatstreaming.music.item.ArtistItemType;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.playlist.AddPlaylistItemBinder;
import com.beatstreaming.music.player.MusicPlayer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class BindModule {
    @Provides
    @Singleton
    public AppServerManager provideAppServerManager() {
        return new DefaultAppServerManager();
    }

    @Provides
    @Singleton
    public HomePage provideHomePage() {
        return new AppHomePage();
    }

    @Provides
    @Singleton
    public Pages[] providePages() {
        return AppPages.values();
    }

    @Provides
    @Singleton
    public TrackListImageItemBinder provideTrackListItemBinder(MusicPlayer player) {
        return new TrackListImageItemBinder(player);
    }

    @Provides
    @Singleton
    public AlbumCardImageItemBinder provideAlbumCardItemBinder() {
        return new AlbumCardImageItemBinder();
    }

    @Provides
    @Singleton
    public ArtistCardImageItemBinder provideArtistCardItemBinder() {
        return new ArtistCardImageItemBinder();
    }

    @Provides
    @Singleton
    public TrackListIndexItemBinder provideTrackListIndexItemBinder(MusicPlayer player) {
        return new TrackListIndexItemBinder(player);
    }

    @Provides
    @Singleton
    public AddPlaylistItemBinder provideAddPlaylistItemBinder() {
        return new AddPlaylistItemBinder();
    }

    @Provides
    @Singleton
    public AlbumItemType provideAlbumItemType() {
        return new AppAlbumItemType();
    }

    @Provides
    @Singleton
    public ArtistItemType provideArtistItemType() {
        return new AppArtistItemType();
    }

    @Provides
    @Singleton
    public PlaylistItemType providePlaylistItemType() {
        return new AppPlaylistItemType();
    }
}