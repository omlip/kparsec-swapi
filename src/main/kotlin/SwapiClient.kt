import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode.Companion.NoContent
import io.ktor.http.HttpStatusCode.Companion.NotFound
import io.ktor.http.HttpStatusCode.Companion.NotModified
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SwapiClient(private val config: SwapiClientConfig) {
    // Default constructor
    constructor() : this(SwapiClientConfig())

    private val client: HttpClient by lazy {
        HttpClient(config.engine) {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                })
            }
            if (config.debug) install(Logging)

            install(HttpTimeout) {
                requestTimeoutMillis = config.timeout
            }
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = config.retry)
                constantDelay()
            }
            install(HttpCache)

            defaultRequest {

                url {
                    protocol = URLProtocol.HTTPS
                    host = config.apiUrl
                }
            }
        }
    }

    companion object {
        fun swapiClient(block: SwapiClientConfig.() -> Unit): SwapiClient {
            val config = SwapiClientConfig().apply(block)
            return SwapiClient(config)
        }
    }

    suspend fun getPeople(id: Int): People? = makeRequest("/api/people/$id")
    suspend fun getPlanet(id: Int): Planet? = makeRequest("/api/planets/$id")
    suspend fun getStarship(id: Int): Starship? = makeRequest("/api/starships/$id")
    suspend fun getVehicle(id: Int): Vehicle? = makeRequest("/api/vehicles/$id")
    suspend fun getFilm(id: Int): Film? = makeRequest("/api/films/$id")
    suspend fun getSpecie(id: Int): Specie? = makeRequest("/api/species/$id")

    suspend fun films(block: FilmCriteria.() -> Unit): SearchResponse<Film> {
        val criteria = FilmCriteria()
        criteria.apply(block)

        return client.get("/api/films/") {
            parameter("search", criteria.title)
        }.body<SearchResponse<Film>>()
    }

    suspend fun people(block: PeopleCriteria.() -> Unit): SearchResponse<People> {
        val criteria = PeopleCriteria()
        criteria.apply(block)

        return client.get("/api/people") {
            parameter("search", criteria.name)
        }.body<SearchResponse<People>>()
    }

    suspend fun vehicles(block: VehicleCriteria.() -> Unit): SearchResponse<Vehicle> {
        val criteria = VehicleCriteria()
        criteria.apply(block)

        return client.get("/api/vehicles") {
            parameter("search", criteria.nameOrModel)
        }.body<SearchResponse<Vehicle>>()
    }

    suspend fun starships(block: VehicleCriteria.() -> Unit): SearchResponse<Starship> {
        val criteria = VehicleCriteria()
        criteria.apply(block)

        return client.get("/api/starships") {
            parameter("search", criteria.nameOrModel)
        }.body<SearchResponse<Starship>>()
    }

    suspend fun species(block: SpecieCriteria.() -> Unit): SearchResponse<Specie> {
        val criteria = SpecieCriteria()
        criteria.apply(block)

        return client.get("/api/species") {
            parameter("search", criteria.name)
        }.body<SearchResponse<Specie>>()
    }

    suspend fun planets(block: PlanetCriteria.() -> Unit): SearchResponse<Planet> {
        val criteria = PlanetCriteria()
        criteria.apply(block)

        return client.get("/api/planets") {
            parameter("search", criteria.name)
        }.body<SearchResponse<Planet>>()
    }

    private suspend inline fun <reified T> makeRequest(endpoint: String): T {
        val response: HttpResponse = client.get(endpoint)

        return when (response.status) {
            OK, NoContent, NotModified, NotFound -> response.body()

            else -> throw GalaxyException("An answer from the galaxy you have received : ${response.status} - ${response.bodyAsText()}")
        }
    }

}

class SwapiClientConfig {
    var retry: Int = 3
    var timeout: Long = 30000
    var debug: Boolean = false
    var engine: HttpClientEngine = CIO.create()
    var apiUrl: String = "swapi.dev"
}

class GalaxyException(message: String? = "Something went wrong in the Force", cause: Throwable? = null) : RuntimeException(message, cause)
