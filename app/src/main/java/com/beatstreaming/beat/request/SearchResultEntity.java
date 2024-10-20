package com.beatstreaming.beat.request;

import com.beatstreaming.core.entity.ItemEntity;
import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;

import lombok.Getter;

@Getter
public class SearchResultEntity extends ItemEntity {
    private TrackEntity[] tracks;
    private ArtistEntity[] artists;
    private AlbumEntity[] albums;
}
