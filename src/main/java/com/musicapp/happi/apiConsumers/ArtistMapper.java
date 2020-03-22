package com.musicapp.happi.apiConsumers;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.dataBase.model.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArtistMapper {

    ArtistMapper INSTANCE = Mappers.getMapper(ArtistMapper.class);

    @Mapping(source = "artist", target = "artistName")
    @Mapping(source = "cover", target = "artistImg")
    @Mapping(source = "Halbum.album", target = "album.albumName")
    @Mapping(source = "Halbum.cover", target = "album.albumImg")
    @Mapping(source = "Halbum.realease", target = "album.realeaseData")
    @Mapping(source= "Htrack.track", target = "track.trackName")
    Artist hartistToArtist(Hartist hartist);
}
