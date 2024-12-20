package com.beatstreaming.beat.module;

import android.content.Context;

import com.beatstreaming.beat.AppMainActivity;
import com.beatstreaming.beat.bind.AlbumSectionContextRegistry;
import com.beatstreaming.beat.bind.BeatSectionContextRegistry;
import com.beatstreaming.beat.item.album.AppAlbumCardImageItemBinder;
import com.beatstreaming.beat.item.album.AppAlbumItemType;
import com.beatstreaming.beat.item.album.AppAlbumListImageItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistItemType;
import com.beatstreaming.beat.item.artist.AppArtistListImageItemBinder;
import com.beatstreaming.beat.item.playlist.AppPlaylistItemType;
import com.beatstreaming.beat.item.track.AppAlbumTrackItemBinder;
import com.beatstreaming.beat.item.track.AppLibraryPlaylistTrackItemBinder;
import com.beatstreaming.beat.item.track.AppPlaylistTrackItemBinder;
import com.beatstreaming.beat.item.track.AppTrackItemType;
import com.beatstreaming.beat.item.track.AppTrackListIndexItemBinder;
import com.beatstreaming.beat.item.artist.AppArtistCardImageItemBinder;
import com.beatstreaming.beat.item.track.AppTrackListImageItemBinder;
import com.beatstreaming.beat.page.AppHomePage;
import com.beatstreaming.beat.page.AppLoadableArtistPage;
import com.beatstreaming.beat.page.AppPages;
import com.beatstreaming.beat.player.BeatPlayer;
import com.beatstreaming.beat.section.AlbumSectionListBinder;
import com.beatstreaming.beat.server.DefaultAppServerManager;
import com.beatstreaming.beat.sheet.AppPlaylistListSheet;
import com.beatstreaming.beat.sheet.AppPlaylistTrackListSheet;
import com.beatstreaming.beat.sheet.AppTrackListSheet;
import com.beatstreaming.core.MainActivity;
import com.beatstreaming.core.bind.SectionContextRegistry;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.beatstreaming.media.player.PlayerContext;
import com.beatstreaming.media.server.AppServerManager;
import com.beatstreaming.media.sheet.MediaListSheet;
import com.beatstreaming.media.sheet.ShareListSheet;
import com.beatstreaming.media.storage.app.AppSourceStorageManager;
import com.beatstreaming.media.storage.history.HistoryListStorageManager;
import com.beatstreaming.media.storage.library.ItemType;
import com.beatstreaming.media.storage.library.LibraryListStorageManager;
import com.beatstreaming.music.item.AlbumItemType;
import com.beatstreaming.music.item.ArtistItemType;
import com.beatstreaming.music.item.ContextLibraryItemBinder;
import com.beatstreaming.music.item.PlaylistItemType;
import com.beatstreaming.music.item.TrackItemType;
import com.beatstreaming.music.item.playlist.AddPlaylistItemBinder;
import com.beatstreaming.music.page.LoadableArtistPage;
import com.beatstreaming.music.player.MusicPlayer;
import com.beatstreaming.music.sheet.playlist.PlaylistListSheet;
import com.beatstreaming.music.sheet.share.AppShareListSheet;
import com.beatstreaming.music.sheet.track.PlaylistTrackListSheet;
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
    @Singleton
    public ContextLibraryItemBinder provideContextLibraryItemBinder() {
        return new ContextLibraryItemBinder();
    }

    @Provides
    @Singleton
    public PlayerContext providePlayerContext(TrackItemType trackItemType, HistoryListStorageManager historyListStorageManager) {
        return new PlayerContext(trackItemType, historyListStorageManager);
    }

    @Provides
    @Singleton
    public MusicPlayer provideMusicPlayer(@ApplicationContext Context context, PlayerContext playerContext) {
        return new BeatPlayer(context, playerContext);
    }

    @Provides
    @Singleton
    public Class<? extends LoadableArtistPage> provideLoadableArtistPage() {
        return AppLoadableArtistPage.class;
    }

    @Provides
    @Singleton
    public AlbumSectionListBinder provideAlbumSectionListBinder(Gson gson, AlbumSectionContextRegistry sectionContextRegistry) {
        return new AlbumSectionListBinder(gson, sectionContextRegistry);
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
    public Class<? extends PlaylistTrackListSheet> provideAppPlaylistTrackListSheet() {
        return AppPlaylistTrackListSheet.class;
    }

    @Provides
    @Singleton
    public Class<? extends PlaylistListSheet> providePlaylistListSheet() {
        return AppPlaylistListSheet.class;
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
    public Class<? extends ShareListSheet> provideShareListSheet() {
        return AppShareListSheet.class;
    }

    @Provides
    @Singleton
    public SectionContextRegistry provideSectionContextRegistry(@ApplicationContext Context context, AppTrackListImageItemBinder appTrackListItemBinder, AppArtistListImageItemBinder appArtistListImageItemBinder, AppAlbumListImageItemBinder appAlbumListImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder) {
        return new BeatSectionContextRegistry(context, appTrackListItemBinder, appArtistListImageItemBinder, appAlbumListImageItemBinder, appArtistCardImageItemBinder, appAlbumCardImageItemBinder);
    }

    @Provides
    @Singleton
    public AlbumSectionContextRegistry provideAlbumSectionContextRegistry(@ApplicationContext Context context, AppAlbumTrackItemBinder appTrackListItemBinder, AppArtistListImageItemBinder appArtistListImageItemBinder, AppAlbumListImageItemBinder appAlbumListImageItemBinder, AppArtistCardImageItemBinder appArtistCardImageItemBinder, AppAlbumCardImageItemBinder appAlbumCardImageItemBinder) {
        return new AlbumSectionContextRegistry(context, appTrackListItemBinder, appArtistListImageItemBinder, appAlbumListImageItemBinder, appArtistCardImageItemBinder, appAlbumCardImageItemBinder);
    }

    @Provides
    @Singleton
    public AppTrackListImageItemBinder provideAppAlbumTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage) {
        return new AppTrackListImageItemBinder(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Provides
    @Singleton
    public AppArtistListImageItemBinder provideAppArtistListImageItemBinder() {
        return new AppArtistListImageItemBinder();
    }

    @Provides
    @Singleton
    public AppAlbumListImageItemBinder provideAppAlbumListImageItemBinder() {
        return new AppAlbumListImageItemBinder();
    }

    @Provides
    @Singleton
    public AppTrackListIndexItemBinder provideTrackListIndexItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage) {
        return new AppTrackListIndexItemBinder(player, trackItemType, trackListSheet, loadableArtistPage);
    }

    @Provides
    @Singleton
    public AppAlbumTrackItemBinder provideAppTrackListItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends TrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage) {
        return new AppAlbumTrackItemBinder(player, trackItemType, trackListSheet, loadableArtistPage);
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
    public AppPlaylistTrackItemBinder provideAppPlaylistTrackItemBinder(MusicPlayer player, TrackItemType trackItemType, Class<? extends PlaylistTrackListSheet> trackListSheet, Class<? extends LoadableArtistPage> loadableArtistPage, LibraryListStorageManager libraryListStorageManager) {
        return new AppPlaylistTrackItemBinder(player, trackItemType, trackListSheet, loadableArtistPage, libraryListStorageManager);
    }

    @Provides
    @Singleton
    public AppLibraryPlaylistTrackItemBinder provideLibraryAppPlaylistTrackItemBinder(AppPlaylistTrackItemBinder appTrackListImageItemBinder) {
        return new AppLibraryPlaylistTrackItemBinder(appTrackListImageItemBinder);
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

    @Provides
    @Singleton
    public Class<? extends MainActivity> provideMainActivity() {
        return AppMainActivity.class;
    }

    @Provides
    @Singleton
    public Class<? extends HomePage> provideHomePage() {
        return AppHomePage.class;
    }
}