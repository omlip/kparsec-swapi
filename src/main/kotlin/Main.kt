import io.kparsec.client.SwapiClient


suspend fun main() {

    val client = SwapiClient()

    /*
    val config = io.kparsec.client.SwapiClientConfig()
    config.retry = 4
    val client3 = io.kparsec.client.SwapiClient(config)

    client3.getPerson(6)?.let {
        println("Name: ${it.name}, Birth Year: ${it.birthYear}")
    }

    val client2 = swapiClient {
        retry = 5
        timeout = 20000
    }

    client2.getPerson(5)?.let {
        println("Name: ${it.name}, Birth Year: ${it.birthYear}")
    }
    */

    // Fetch a person

    client.getPeople(1)?.let {
        println("Name: ${it.name}, Birth Year: ${it.birthYear} ,,,,,, created date ${it.created}")
    }

    /*
    val searchPeople = client.people {
        name matching "jar jar"
    }

    println(searchPeople.results.map { "${it.name} - ${it.birthYear}" })
*/


    // Fetch a io.kparsec.client.models.Planet
    client.getPlanet(1)?.let {
        println("io.kparsec.client.models.Planet: ${it.name}, Rotation Period: ${it.rotationPeriod}")
    }

    client.getStarship(9)?.let {
        println("io.kparsec.client.models.Starship: ${it.name}, Hyperdrive Rating: ${it.hyperdriveRating}")

    }

    // Fetch a vehicle
    client.getVehicle(4)?.let {
        println("io.kparsec.client.models.Vehicle: ${it.name}")
    }

    // Fetch a species
    client.getSpecie(3)?.let {
        println("Species: ${it.name}")
    }

    // Fetch a film

    client.getFilm(1)?.let {
        println("io.kparsec.client.models.Film: ${it.title}")
    }


/*
    val search = client.films {
        title matching "revenge"
    }

    println(search.results.map { "${it.title} by ${it.producer}" })


 */

}
