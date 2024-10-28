package com.beatstreaming.beat.server;

import com.beatstreaming.media.server.AppServerManager;

public class DefaultAppServerManager extends AppServerManager {
    public DefaultAppServerManager() {
        super(new DefaultAppServer());
    }
}
