package com.beatstreaming.beat.server;

import com.beatstreaming.media.server.AppServer;

import java.net.URISyntaxException;

public class DefaultAppServer extends AppServer {
    public DefaultAppServer() throws URISyntaxException {
        super(new URIBuilder().setScheme("https").setHost("api.beatstreaming.com").build());
    }
}
