package com.musicapp.happi.dataBase;

import com.musicapp.happi.dataBase.model.Album;
import com.musicapp.happi.dataBase.model.Artist;
import com.musicapp.happi.dataBase.model.Track;
import com.musicapp.happi.dataBase.repository.AlbumRepository;
import com.musicapp.happi.dataBase.repository.ArtistReposiotry;
import com.musicapp.happi.dataBase.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbSeeder {
    private final ArtistReposiotry artistReposiotry;
    private final TrackRepository trackRepository;
    private final AlbumRepository albumRepository;

    @Autowired
    public DbSeeder(ArtistReposiotry artistReposiotry, TrackRepository trackRepository, AlbumRepository albumRepository) {
        this.artistReposiotry = artistReposiotry;
        this.trackRepository = trackRepository;
        this.albumRepository = albumRepository;
    }


    private void saveArtist(Artist a){
        a.getAlbums().forEach(
                x -> trackRepository.saveAll(x.getTracks())
        );

        albumRepository.saveAll(a.getAlbums());

        artistReposiotry.save(a);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setDbInitData(){


        Artist alek = new Artist(
                "alekIdFromApi",
                "Aleksander 'Dusza Artysty' Szamalek",
                "C:/twojaStara.jpg",
                "happi/do/pappi/alek.xD",
                "Alek zajebiscice gra na swojej kurwa Gitarce. i. c.h.u.j.",
                "happi/alek'sAlbumsList",
                Arrays.asList(
                        new Album(
                                "album#asdfasfaw",
                                "ONA MA JUSZ MOKRO. MOOOOOODRDO",
                                "C:/onaMaMokro.jp100%",
                                "12/06/1999",
                                "happi/onaMaMokro.xD",
                                Arrays.asList(
                                        new Track(
                                                "fjewipoqsadf",
                                                "Wchodze bez pukania",
                                                "Wchodze bez pukania, czas to jest jebania, ona MORDO ma jusz mokro, nawet sekunde nie miala wilgotno. joł",
                                                "happi/wchodzeBezPukania"
                                        ),
                                        new Track(
                                                "dsaf432qfadf",
                                                "z Papi do Japi",
                                                "teraz bedzie z Papi, potem pakuje do Japi, czas mi mija na ruchaniu, a nie cipek omijaniu. nhn",
                                                "happi/Pappi&Jappi"
                                        )

                                )
                        ),
                        new Album(
                                "album#fdsagfwga",
                                "Kupe sobie sczele z rana",
                                "gunwo.jp100%",
                                "12/06/2009",
                                "happi/kupka.xD",
                                Arrays.asList(
                                        new Track(
                                                "fdsaf3",
                                                "Ale ja chce u tomka",
                                                "plum plum plum, takie dziweki wydaje moja kupa gdy z dupy do kibla sie skupia",
                                                "happi/uTomka"
                                        )
                                )
                        )
                )
        );

        Artist maks = new Artist(
                "asdfahw342hasdf",
                "Magz I chuj",
                "C:/twojStary.jpg",
                "happi/do/pappi/magz.xD",
                "No siema witam w mojej kuchni, dzisiaj wam pokaze ze muzyka to tez jest jak gotowanie tylko ze jest wiecej matmy, zapraszam i. c.h.u.j.",
                "happi/maksi'sAlbumsList",
                Arrays.asList(
                        new Album(
                                "fewq#asdfasfaw",
                                "Pierdole to hehehe.",
                                "jebanie.jp100%",
                                "12/09/1998",
                                "happi/onaMaMfdasfew.xD",
                                Arrays.asList(
                                        new Track(
                                                "asdfawf3awdfsaga32",
                                                "aj dont giw e fak",
                                                "aj don giw e fak, biqoz yts rak yo",
                                                "happi/fak"
                                        ),
                                        new Track(
                                                "fa3faw34f",
                                                "ah SHIT hir we gol egen",
                                                "hehe jebanie i tyle w temacie momooooooordy",
                                                "happi/shit"
                                        )

                                )
                        ),
                        new Album(
                                "album#fdsagfwgasdwefasdfaw3tf",
                                "Hanna&Karo",
                                "bylaAObecna.jp100%",
                                "12/05/2009",
                                "happi/ups.xD",
                                Arrays.asList(
                                        new Track(
                                                "fdasdfawesaf3",
                                                "Karo A Hanna",
                                                "Jedna matma druga flet, z kazda lubie jebac sie",
                                                "happi/upsi"
                                        )
                                )
                        )
                )
        );

        this.artistReposiotry.deleteAll();
        this.albumRepository.deleteAll();
        this.trackRepository.deleteAll();

        saveArtist(alek);
        saveArtist(maks);


    }
}
