package com.beatstreaming.beat.module;

import com.beatstreaming.beat.page.AppHomePage;
import com.beatstreaming.beat.page.AppPages;
import com.beatstreaming.beat.server.DefaultAppServerManager;
import com.beatstreaming.core.pages.HomePage;
import com.beatstreaming.core.pages.Pages;
import com.beatstreaming.media.server.AppServerManager;

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
}