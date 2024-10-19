package com.beatstreaming.beat.server;

import com.beatstreaming.media.server.AppServer;

import org.apache.http.client.utils.URIBuilder;

import java.net.URI;

import lombok.SneakyThrows;

public class DefaultAppServer extends AppServer {
    @Override
    @SneakyThrows
    public URI getUrl() {
        return new URIBuilder().setScheme("https").setHost("api.beatstreaming.com").build();
    }
}
