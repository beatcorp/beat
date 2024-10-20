package com.beatstreaming.beat.payload;

import lombok.Getter;

@Getter
public class ArtistPayload extends IdPayload {
    public ArtistPayload(String id) {
        super(id);
    }
}
