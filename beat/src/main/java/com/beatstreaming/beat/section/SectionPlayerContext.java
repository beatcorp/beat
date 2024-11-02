package com.beatstreaming.beat.section;

import com.beatstreaming.core.list.ListContext;
import com.beatstreaming.media.player.PlayerContext;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class SectionPlayerContext extends ListContext {
    private final PlayerContext playerContext;
}
