Endpoints
=======

## Artist data endpoints 


**1 Get All Artists List**
**1.1 Path**

*GET /artists*

    localhost:8080/artists

**1.2 Response**

Response is LIST of ArtistMetaData:

| Field name | Field type |                description                |
|:----------:|:----------:|:-----------------------------------------:|
|     id     |   String   | Unique ID that define ARTIST in dataBase. |
|    name    |   String   |              Name of artist.              |
|     img    |   String   |  URL address of artist background image.  |


```yaml
[
    {
        "id": "5e6ea5b31ff4ae717303aa72",
        "name": "Aleksander 'Dusza Artysty' Szamalek",
        "img": "C:/twojaStara.jpg"
    },
    {
        "id": "5e6ea5b31ff4ae717303aa78",
        "name": "Magz I chuj",
        "img": "C:/twojStary.jpg"
    }
]
```

**2 Get Single Artist Data**
**2.1 Path**

*GET /artists/{id}*

    localhost:8080/artists/5e6ea5b31ff4ae717303aa72

**2.2 Response**

Single Artist response

|  Field name |  Field type |                description                |
|:-----------:|:-----------:|:-----------------------------------------:|
|      id     |    String   | Unique ID that define ARTIST in dataBase. |
|     name    |    String   |              Name of artist.              |
|     img     |    String   |  URL address of artist background image.  |
| discription | String      | -                                         |
| albums      | List<Album> | LIST of [AlbumMetaData](#AlbumsMetaData)  |

### AlbumMetaData #

|  Field name  | Field type |                description               |
|:------------:|:----------:|:----------------------------------------:|
|      id      |   String   | Unique ID that define Album in dataBase. |
|     name     |   String   |              Name of Album.              |
|      img     |   String   |  URL address of album background image.  |
| realeaseDate |   String   |           In format: dd/mm/yyyy          |

```yaml
{
    "id": "5e6ea5b31ff4ae717303aa72",
    "name": "Aleksander 'Dusza Artysty' Szamalek",
    "img": "C:/twojaStara.jpg",
    "discription": "Alek zajebiscice gra na swojej kurwa Gitarce. i. c.h.u.j.",
    "albums": [
        {
            "id": "5e6ea5b31ff4ae717303aa70",
            "name": "ONA MA JUSZ MOKRO. MOOOOOODRDO",
            "img": "C:/onaMaMokro.jp100%",
            "realeaseDate": "12/06/1999"
        },
        {
            "id": "5e6ea5b31ff4ae717303aa71",
            "name": "Kupe sobie sczele z rana",
            "img": "gunwo.jp100%",
            "realeaseDate": "12/06/2009"
        }
    ]
}
```

## Album data response

**1. Path**
   
*GET /album/{id}*

    localhost:8080/5e6ea5b31ff4ae717303aa70

**2. Response**

Single Album response

|  Field name  |      Field type     |                description               |
|:------------:|:-------------------:|:----------------------------------------:|
|      id      |        String       | Unique ID that define Album in dataBase. |
|     name     |        String       |              Name of Album.              |
|      img     |        String       |  URL address of album background image.  |
| realeaseDate |        String       |           In format: dd/mm/yyyy          |
|    tracks    | List<TrackMetaData> |           List of [TrackMetaData](#TrackMetaData)          |

### TrackMetaData #

| Field name | Field type |                description               |
|:----------:|:----------:|:----------------------------------------:|
|     id     |   String   | Unique ID that define Track in dataBase. |
|    name    |   String   |              Name of Track.              |

```yuml
{
    "id": "5e6ea5b31ff4ae717303aa70",
    "name": "ONA MA JUSZ MOKRO. MOOOOOODRDO",
    "img": "C:/onaMaMokro.jp100%",
    "realeaseDate": "12/06/1999",
    "tracks": [
        {
            "id": "5e6ea5b31ff4ae717303aa6d",
            "name": "Wchodze bez pukania"
        },
        {
            "id": "5e6ea5b31ff4ae717303aa6e",
            "name": "z Papi do Japi"
        }
    ]
}
```

## Track data response

1. Path

*GET /track/{id}*

    localhost:8080/track/5e6ea5b31ff4ae717303aa6d

2. Response

Single Track response

| Field name | Field type |                description               |
|:----------:|:----------:|:----------------------------------------:|
|     id     |   String   | Unique ID that define Track in dataBase. |
|    name    |   String   |              Name of Track.              |
|   lyrics   |   String   |              lyrics of song.             |

```yuml
{
    "id": "5e6ea5b31ff4ae717303aa6d",
    "name": "Wchodze bez pukania",
    "lyrics": "Wchodze bez pukania, czas to jest jebania, ona MORDO ma jusz mokro, nawet sekunde nie miala wilgotno. joł"
}
```