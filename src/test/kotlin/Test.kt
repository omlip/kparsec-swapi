import SwapiClient.Companion.swapiClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondError
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.time.measureTime

class KtorClientTest {

    @Test
    fun testMakeCachedRequest_Success() = runBlocking {
        val mockEngine = MockEngine { request ->
            val ifNoneMatch = request.headers["If-None-Match"]
            val content = """{
                                "name": "Luke Skywalker",
                                "height": "172",
                                "mass": "77",
                                "birth_year": "19BBY",
                                "gender": "male"
                            }""".trimMargin()
            if (ifNoneMatch == null) {
                respond(
                    content = content,
                    status = HttpStatusCode.OK,
                    headers = headersOf(
                        Pair(HttpHeaders.ETag, listOf("\"123456\"")),
                        Pair(HttpHeaders.CacheControl, listOf("max-age=3600"))
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
        val cachedResponse = client.getPeople(2)

        assertEquals(initialResponse?.name, cachedResponse?.name)

        // Verify that the mock engine was called twice
        assertEquals(2, mockEngine.requestHistory.size)

        // Verify that the second request included the If-None-Match header
        val secondRequest = mockEngine.requestHistory[1]
        assertEquals("\"123456\"", secondRequest.headers["If-None-Match"])

    }

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


    /*
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
