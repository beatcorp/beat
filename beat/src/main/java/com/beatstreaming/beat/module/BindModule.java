package com.beatstreaming.beat.module;

import android.content.Context;

import com.beatstreaming.beat.bind.AlbumSectionContextRegistry;
import com.beatstreaming.beat.bind.BeatSectionContextRegistry;
import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.album.AppAlbumItemType;
import com.beatstreaming.beat.item.artist.AppArtistItemType;
import com.beatstreaming.beat.item.playlist.AppPlaylistItemType;
import com.beatstreaming.beat.item.track.AppPlaylistTrackItemBinder;
import com.beatstreaming.beat.item.track.AppTrackItemType;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListItemBinder;
import com.beatstreaming.beat.page.AppHomePage;
import com.beatstreaming.beat.page.AppPages;
import com.beatstreaming.beat.section.PlayableSectionListBinder;
import com.beatstreaming.beat.server.DefaultAppServerManager;
import com.beatstreaming.beat.sheet.AppTrackListSheet;
import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.beatstreaming.media.server.AppServerManager;
import com.beatstreaming.media.sheet.MediaListSheet;
import com.beatstreaming.media.storage.app.AppSourceStorageManager;
import com.beatstreaming.media.storage.library.ItemType;
import com.beatstreaming.media.storage.library.LibraryListStorageManager;
import com.beatstreaming.music.item.AlbumItemType;
import com.beatstreaming.music.item.ArtistItemType;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.item.playlist.AddPlaylistItemBinder;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.sheet.track.TrackListSheet;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class BindModule {
    @Provides
    public PlayableSectionListBinder provideSectionListBinder(Gson gson, SectionContextRegistry sectionContextRegistry) {
        return new PlayableSectionListBinder(gson, sectionContextRegistry);
    }

    @Provides
    @Singleton
    public AppServerManager provideAppServerManager() {
        return new DefaultAppServerManager();
    }

    @Provides
    @Singleton
    public AppSourceStorageManager provideAppSourceStorageManager(Gson gson) {
        return new AppSourceStorageManager(gson);
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
    public Class<? extends MediaListSheet> provideAppTrackListSheet() {
        return AppTrackListSheet.class;
    }

    @Provides
    @Singleton
    public TrackItemType provideTrackItemType() {
        return new AppTrackItemType();
    }

    @Provides
    @Singleton
    public ItemType provideItemType(TrackItemType trackItemType) {
        return trackItemType;
    }

    @Provides
    @Singleton
    public Class<? extends TrackListSheet> provideTrackListSheet() {
        return AppTrackListSheet.class;
    }

    @Provides
    @Singleton
    public BeatSectionContextRegistry provideBeatBindList(@ApplicationContext Context context, AppTrackListImageItemBinder appTrackListItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder) {
        return new BeatSectionContextRegistry(context, appTrackListItemBinder, appAlbumCardImageItemBinder, appArtistCardImageItemBinder);
    }

    @Provides
    @Singleton
    public AlbumSectionContextRegistry provideAlbumSectionContextRegistry(@ApplicationContext Context context, AppTrackListImageItemBinder appTrackListItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder, AppTrackListIndexItemBinder appTrackListIndexItemBinder) {
        return new AlbumSectionContextRegistry(context, appTrackListItemBinder, appAlbumCardImageItemBinder, appArtistCardImageItemBinder, appTrackListIndexItemBinder);
    }

    @Provides
    @Singleton
    public SectionContextRegistry provideSectionContextRegistry(BeatSectionContextRegistry beatSectionContextRegistry) {
        return beatSectionContextRegistry;
    }

    @Provides
    @Singleton
    public AppTrackListImageItemBinder provideTrackListItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        return new AppTrackListImageItemBinder(player, trackItemType, trackListSheet);
    }

    @Provides
    @Singleton
    public AppTrackListIndexItemBinder provideTrackListIndexItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        return new AppTrackListIndexItemBinder(player, trackItemType, trackListSheet);
    }

    @Provides
    @Singleton
    public AppTrackListItemBinder provideAppTrackListItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet) {
        return new AppTrackListItemBinder(player, trackItemType, trackListSheet);
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
    public AppPlaylistTrackItemBinder provideAppPlaylistTrackItemBinder(AppTrackListImageItemBinder appTrackListImageItemBinder) {
        return new AppPlaylistTrackItemBinder(appTrackListImageItemBinder);
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