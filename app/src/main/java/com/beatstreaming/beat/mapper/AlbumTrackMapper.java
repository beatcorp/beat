package com.beatstreaming.beat.mapper;

import com.beatstreaming.music.entity.TrackEntity;
import com.beatstreaming.music.entity.cast.AlbumTrackEntity;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AlbumTrackMapper {
    AlbumTrackMapper INSTANCE = Mappers.getMapper(AlbumTrackMapper.class);

    AlbumTrackEntity toAlbumTrackEntity(TrackEntity trackEntity);
}