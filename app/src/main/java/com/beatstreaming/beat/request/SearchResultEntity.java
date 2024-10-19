package com.beatstreaming.beat.request;

import com.beatstreaming.music.entity.TrackEntity;

import java.util.List;

import lombok.Getter;

@Getter
public class SearchResultEntity {
    private List<TrackEntity> tracks;
}
