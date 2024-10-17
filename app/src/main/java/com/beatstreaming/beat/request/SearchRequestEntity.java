package com.beatstreaming.beat.request;

import com.beatstreaming.beat.entity.TrackEntity;

import java.util.List;

import lombok.Getter;

@Getter
public class SearchRequestEntity {
    private List<TrackEntity> tracks;
}
