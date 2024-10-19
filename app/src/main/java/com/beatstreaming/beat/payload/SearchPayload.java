package com.beatstreaming.beat.payload;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SearchPayload {
    private final String query;
}
