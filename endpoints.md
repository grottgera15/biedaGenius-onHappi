Endpoints
=========

Artist data endpoints
---------------------

1. Operations
1.1 Get All Artists List
1.1.1 Path

*GET /artists*

1.1.2 Response

Response is List of ArtistMetaData:

| Field name | Field type |                description                |
|:----------:|:----------:|:-----------------------------------------:|
|     id     |   String   | Unique ID that define ARTIST in dataBase. |
|    name    |   String   |              Name of artist.              |
|     img    |   String   |  URL address of artist background image.  |

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

1.2 Get Single Artist Data
1.1.1 Path

*GET /artists/{id}*

1.1.2 Response

Single Artist response

|  Field name |  Field type |                description                |
|:-----------:|:-----------:|:-----------------------------------------:|
|      id     |    String   | Unique ID that define ARTIST in dataBase. |
|     name    |    String   |              Name of artist.              |
|     img     |    String   |  URL address of artist background image.  |
| discription | String      | -                                         |
| albums      | List<Album> | List of [AlbumsMetaData](AlbumsMetaData)  |

AlbumsMetaData

|  Field name  | Field type |                description               |
|:------------:|:----------:|:----------------------------------------:|
|      id      |   String   | Unique ID that define Album in dataBase. |
|     name     |   String   |              Name of Album.              |
|      img     |   String   |  URL address of album background image.  |
| realeaseDate |   String   |           In format: dd/mm/yyyy          |

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

Album data response
-------------------
