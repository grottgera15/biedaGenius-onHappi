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
                "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-8/p960x960/15039647_1124748574281831_9178505682944436220_o.jpg?_nc_cat=101&_nc_sid=85a577&_nc_ohc=vHyAGyMNkGwAX-tUtKK&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=0a08ebfd533bdb42b799ddf926f1587c&oe=5E952BAE",
                "happi/do/pappi/alek.xD",
                "Alek zajebiscice gra na swojej kurwa Gitarce. i. c.h.u.j.",
                "happi/alek'sAlbumsList",
                Arrays.asList(
                        new Album(
                                "album#asdfasfaw",
                                "ONA MA JUSZ MOKRO. MOOOOOODRDO",
                                "https://scontent-waw1-1.xx.fbcdn.net/v/t1.0-9/11156142_784314594991899_2874198081674526601_n.jpg?_nc_cat=101&_nc_sid=7aed08&_nc_ohc=ebEdQVwmsIMAX9ZY952&_nc_ht=scontent-waw1-1.xx&oh=2e02d6b844f80ac076548677256a26fe&oe=5E979802",
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
                                "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-8/11709922_818958814860810_28242477012168652_o.jpg?_nc_cat=100&_nc_sid=dd9801&_nc_ohc=yzeg0lHL5eIAX9ca4P9&_nc_ht=scontent-waw1-1.xx&oh=7364dccfb24ad6f014354172ced9640a&oe=5E979AE9",
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
                "https://scontent-waw1-1.xx.fbcdn.net/v/t1.0-1/p960x960/84829814_3509320042476802_6790332536082923520_o.jpg?_nc_cat=108&_nc_sid=dbb9e7&_nc_ohc=Y6IH2Rn974oAX89-M51&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=a9c8fee167096b4bc93659969360ffdf&oe=5E953550",
                "happi/do/pappi/magz.xD",
                "No siema witam w mojej kuchni, dzisiaj wam pokaze ze muzyka to tez jest jak gotowanie tylko ze jest wiecej matmy, zapraszam i. c.h.u.j.",
                "happi/maksi'sAlbumsList",
                Arrays.asList(
                        new Album(
                                "fewq#asdfasfaw",
                                "Pierdole to hehehe.",
                                "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-0/p640x640/26240076_1656633317729613_3937414924389579923_o.jpg?_nc_cat=111&_nc_sid=e007fa&_nc_ohc=ilouKLJADJkAX9ebtWa&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=04d0f0227231c8a679376d9a1c96f664&oe=5E94904B",
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
                                "https://scontent-waw1-1.xx.fbcdn.net/v/t31.0-8/p960x960/14976770_1258743520852637_1448091983873138492_o.jpg?_nc_cat=105&_nc_sid=85a577&_nc_ohc=CIgmmsULnEQAX_o39l1&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=c7be5d4cfe6771e85b9d75641c369ba1&oe=5E965B0E",
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
