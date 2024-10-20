package com.beatstreaming.beat.payload;

import lombok.Getter;

@Getter
public class AlbumPayload extends IdPayload {
    public AlbumPayload(String id) {
        super(id);
    }
}
