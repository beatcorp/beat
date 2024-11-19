package com.beatstreaming.beat.entity;

import com.beatstreaming.media.entity.PlayerSourceDataEntity;
import com.beatstreaming.media.entity.PlayerSourceEntity;

public class TrackSourceEntity extends PlayerSourceEntity {
    public TrackSourceEntity(String method, PlayerSourceDataEntity data) {
        super(method, data);
    }
}
