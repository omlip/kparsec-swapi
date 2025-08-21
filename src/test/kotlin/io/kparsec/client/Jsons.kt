package io.kparsec.client

val LUKE_SKYWALKER =
    """{
	        "name": "Luke Skywalker",
	        "height": "172",
	        "mass": "77",
	        "hair_color": "blond",
	        "skin_color": "fair",
	        "eye_color": "blue",
	        "birth_year": "19BBY",
	        "gender": "male",
	        "homeworld": "https://swapi.info/api/planets/1",
	        "films": [
	        	"https://swapi.info/api/films/1",
	        	"https://swapi.info/api/films/2",
	        	"https://swapi.info/api/films/3",
	        	"https://swapi.info/api/films/6"
	        ],
	        "species": [],
	        "vehicles": [
	        	"https://swapi.info/api/vehicles/14",
	        	"https://swapi.info/api/vehicles/30"
	        ],
	        "starships": [
	        	"https://swapi.info/api/starships/12",
	        	"https://swapi.info/api/starships/22"
	        ],
	        "created": "2014-12-09T13:50:51.644000Z",
	        "edited": "2014-12-20T21:17:56.891000Z",
	        "url": "https://swapi.info/api/people/1"
        }""".trimMargin()


val THE_PHANTOM_MENACE =
    """{
  "title": "The Phantom Menace",
  "episode_id": 1,
  "opening_crawl": "Turmoil has engulfed the\r\nGalactic Republic. The taxation\r\nof trade routes to outlying star\r\nsystems is in dispute.\r\n\r\nHoping to resolve the matter\r\nwith a blockade of deadly\r\nbattleships, the greedy Trade\r\nFederation has stopped all\r\nshipping to the small planet\r\nof Naboo.\r\n\r\nWhile the Congress of the\r\nRepublic endlessly debates\r\nthis alarming chain of events,\r\nthe Supreme Chancellor has\r\nsecretly dispatched two Jedi\r\nKnights, the guardians of\r\npeace and justice in the\r\ngalaxy, to settle the conflict....",
  "director": "George Lucas",
  "producer": "Rick McCallum",
  "release_date": "1999-05-19",
  "characters": [
    "https://swapi.info/api/people/2",
    "https://swapi.info/api/people/3",
    "https://swapi.info/api/people/10",
    "https://swapi.info/api/people/11",
    "https://swapi.info/api/people/16",
    "https://swapi.info/api/people/20",
    "https://swapi.info/api/people/21",
    "https://swapi.info/api/people/32",
    "https://swapi.info/api/people/33",
    "https://swapi.info/api/people/34",
    "https://swapi.info/api/people/35",
    "https://swapi.info/api/people/36",
    "https://swapi.info/api/people/37",
    "https://swapi.info/api/people/38",
    "https://swapi.info/api/people/39",
    "https://swapi.info/api/people/40",
    "https://swapi.info/api/people/41",
    "https://swapi.info/api/people/42",
    "https://swapi.info/api/people/43",
    "https://swapi.info/api/people/44",
    "https://swapi.info/api/people/46",
    "https://swapi.info/api/people/47",
    "https://swapi.info/api/people/48",
    "https://swapi.info/api/people/49",
    "https://swapi.info/api/people/50",
    "https://swapi.info/api/people/51",
    "https://swapi.info/api/people/52",
    "https://swapi.info/api/people/53",
    "https://swapi.info/api/people/54",
    "https://swapi.info/api/people/55",
    "https://swapi.info/api/people/56",
    "https://swapi.info/api/people/57",
    "https://swapi.info/api/people/58",
    "https://swapi.info/api/people/59"
  ],
  "planets": [
    "https://swapi.info/api/planets/1",
    "https://swapi.info/api/planets/8",
    "https://swapi.info/api/planets/9"
  ],
  "starships": [
    "https://swapi.info/api/starships/31",
    "https://swapi.info/api/starships/32",
    "https://swapi.info/api/starships/39",
    "https://swapi.info/api/starships/40",
    "https://swapi.info/api/starships/41"
  ],
  "vehicles": [
    "https://swapi.info/api/vehicles/33",
    "https://swapi.info/api/vehicles/34",
    "https://swapi.info/api/vehicles/35",
    "https://swapi.info/api/vehicles/36",
    "https://swapi.info/api/vehicles/37",
    "https://swapi.info/api/vehicles/38",
    "https://swapi.info/api/vehicles/42"
  ],
  "species": [
    "https://swapi.info/api/species/1",
    "https://swapi.info/api/species/2",
    "https://swapi.info/api/species/6",
    "https://swapi.info/api/species/11",
    "https://swapi.info/api/species/12",
    "https://swapi.info/api/species/13",
    "https://swapi.info/api/species/14",
    "https://swapi.info/api/species/15",
    "https://swapi.info/api/species/16",
    "https://swapi.info/api/species/17",
    "https://swapi.info/api/species/18",
    "https://swapi.info/api/species/19",
    "https://swapi.info/api/species/20",
    "https://swapi.info/api/species/21",
    "https://swapi.info/api/species/22",
    "https://swapi.info/api/species/23",
    "https://swapi.info/api/species/24",
    "https://swapi.info/api/species/25",
    "https://swapi.info/api/species/26",
    "https://swapi.info/api/species/27"
  ],
  "created": "2014-12-19T16:52:55.740000Z",
  "edited": "2014-12-20T10:54:07.216000Z",
  "url": "https://swapi.info/api/films/4"
}""".trimMargin()


val PLANET_HOTH =   """{
        "name": "Hoth",
        "rotation_period": "23",
        "orbital_period": "549",
        "diameter": "7200",
        "climate": "frozen",
        "gravity": "1.1 standard",
        "terrain": "tundra, ice caves, mountain ranges",
        "surface_water": "100",
        "population": "unknown",
        "residents": [],
        "films": [
        "https://swapi.info/api/films/2"
        ],
        "created": "2014-12-10T11:39:13.934000Z",
        "edited": "2014-12-20T20:58:18.423000Z",
        "url": "https://swapi.info/api/planets/4"
    }""".trimMargin()
