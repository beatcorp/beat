package com.beatstreaming.beat.payload;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class IdPayload {
    private final String id;
}
