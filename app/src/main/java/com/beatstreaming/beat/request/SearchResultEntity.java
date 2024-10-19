package com.beatstreaming.beat.request;

import com.beatstreaming.music.entity.AlbumEntity;
import com.beatstreaming.music.entity.ArtistEntity;
import com.beatstreaming.music.entity.TrackEntity;

import java.util.List;

import lombok.Getter;

@Getter
public class SearchResultEntity {
    private List<TrackEntity> tracks;
    private List<ArtistEntity> artists;
    private List<AlbumEntity> albums;
}
