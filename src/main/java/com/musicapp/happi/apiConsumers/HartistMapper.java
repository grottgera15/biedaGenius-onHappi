package com.musicapp.happi.apiConsumers;

import com.musicapp.happi.apiConsumers.happi.model.responseClass.Halbum;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Hartist;
import com.musicapp.happi.apiConsumers.happi.model.responseClass.Htrack;
import com.musicapp.happi.dataBase.model.Album;
import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.model.Track;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HartistMapper extends ArtistMapper {

    HartistMapper INSTANCE = Mappers.getMapper(HartistMapper.class);

    @Mapping(source = "artist", target = "artistName")
    @Mapping(source = "cover", target = "artistImg")
    Artist hartistToArtist(Hartist hartist);

    @Mapping(source = "album", target = "albumName")
    @Mapping(source = "cover", target = "albumImg")
    @Mapping(source = "realease", target = "realeaseDate")
    Album halbumToAlbum(Halbum halbum);

    @Mapping(source= "track", target = "trackName")
    Track htackToTrack(Htrack htrack);
}
