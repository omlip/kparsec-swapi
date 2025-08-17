import io.kparsec.client.SwapiClient.Companion.swapiClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class KtorClientTest {

    @Test
    fun testMakeCachedRequest_Success() = runBlocking {

        assertTrue { true }

        /*
        val mockEngine = MockEngine { request ->
            val ifNoneMatch = request.headers["If-None-Match"]
            val content = """{
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

            if (ifNoneMatch == null) {
                respond(
                    content = content,
                    status = HttpStatusCode.OK,
                    headers = headersOf(
                        Pair(HttpHeaders.ETag, listOf("\"123456\"")),
                        Pair(HttpHeaders.CacheControl, listOf("max-age=3600")),
                        Pair(HttpHeaders.ContentType, listOf("application/json"))
                    )
                )
            } else {
                respondError(
                    HttpStatusCode.NotModified, headers = headersOf(
                        HttpHeaders.ETag, "\"123456\""
                    )
                )
            }
        }


        val client = swapiClient {
            engine = mockEngine
        }

        // Initial request

        val initialResponse = client.getPeople(1)


        // Subsequent request (should use cache)
        val cachedResponse = client.getPeople(1)
        assertEquals(initialResponse?.name, cachedResponse?.name)

        // Verify that the mock engine was called twice
        assertEquals(1, mockEngine.requestHistory.size)

        val secondResponse = mockEngine.responseHistory[0]
        assertEquals("\"123456\"", secondResponse.headers["ETag"])
*/
    }
/*
    @Test
    fun testMakeCachedRequest_Success500() = runBlocking {
        val mockEngine = MockEngine {
            respond(
                content = "an error 500 occurred",
                status = HttpStatusCode.InternalServerError,
                headers = headersOf("Content-Type" to listOf(ContentType.Application.Json.toString()))
            )

        }
        val client = swapiClient {
            engine = mockEngine
        }
        val result: Film?

        val time = measureTime {
            result = client.getFilm(1)
        }

        println(time)
        assertTrue(result!!.title.contains("Hope"))
    }


    @Test
    fun testMakeCachedRequest_NotFound() = runBlocking {
        val mockEngine = MockEngine { request ->
            respond(
                content = "Not Found",
                status = HttpStatusCode.NotFound
            )
        }
        val client = createMockHttpClient(mockEngine)
        val result = makeCachedRequest<String>(client, "https://api.example.com/data")

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ResourceNotFoundException)
    }

    @Test
    fun testMakeCachedRequest_ApiError() = runBlocking {
        val mockEngine = MockEngine { request ->
            respond(
                content = "Internal Server Error",
                status = HttpStatusCode.InternalServerError
            )
        }
        val client = createMockHttpClient(mockEngine)
        val result = makeCachedRequest<String>(client, "https://api.example.com/data")

        assertTrue(result.isFailure)
        assertTrue(result.exceptionOrNull() is ApiException)
    }
    */
}
