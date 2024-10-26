package com.beatstreaming.beat.module;

import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.album.AppAlbumItemType;
import com.beatstreaming.beat.item.artist.AppArtistItemType;
import com.beatstreaming.beat.item.playlist.AppPlaylistItemType;
import com.beatstreaming.beat.item.track.AppTrackItemType;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.page.AppHomePage;
import com.beatstreaming.beat.page.AppPages;
import com.beatstreaming.beat.server.DefaultAppServerManager;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.beatstreaming.media.server.AppServerManager;
import com.beatstreaming.media.storage.library.LibraryListStorageManager;
import com.beatstreaming.music.item.AlbumItemType;
import com.beatstreaming.music.item.ArtistItemType;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.TrackItemType;
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
    public AppTrackListImageItemBinder provideTrackListItemBinder(MusicPlayer player, TrackItemType trackItemType) {
        return new AppTrackListImageItemBinder(player, trackItemType);
    }

    @Provides
    @Singleton
    public AppTrackListIndexItemBinder provideTrackListIndexItemBinder(MusicPlayer player, TrackItemType trackItemType) {
        return new AppTrackListIndexItemBinder(player, trackItemType);
    }

    @Provides
    @Singleton
    public AddPlaylistItemBinder provideAddPlaylistItemBinder(LibraryListStorageManager libraryListStorageManager, TrackItemType trackItemType) {
        return new AddPlaylistItemBinder(libraryListStorageManager, trackItemType);
    }

    @Provides
    @Singleton
    public AppAlbumCardImageItemBinder provideAlbumCardItemBinder() {
        return new AppAlbumCardImageItemBinder();
    }

    @Provides
    @Singleton
    public AppArtistCardImageItemBinder provideArtistCardItemBinder() {
        return new AppArtistCardImageItemBinder();
    }

    @Provides
    @Singleton
    public TrackItemType provideTrackItemType() {
        return new AppTrackItemType();
    }

    @Provides
    @Singleton
    public ArtistItemType provideArtistItemType() {
        return new AppArtistItemType();
    }

    @Provides
    @Singleton
    public AlbumItemType provideAlbumItemType() {
        return new AppAlbumItemType();
    }

    @Provides
    @Singleton
    public PlaylistItemType providePlaylistItemType() {
        return new AppPlaylistItemType();
    }
}