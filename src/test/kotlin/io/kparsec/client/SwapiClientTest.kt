package io.kparsec.client

import io.kparsec.client.SwapiClient.Companion.swapiClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class SwapiClientTest {

    @Test
    fun `Luke Skywalker can be serialized`() = runBlocking {

        val mockEngine = MockEngine {

            respond(
                status = HttpStatusCode.OK,
                headers = headersOf(
                    Pair(HttpHeaders.ContentType, listOf("application/json"))
                ),
                content = LUKE_SKYWALKER
            )

        }

        val client = swapiClient {
            engine = mockEngine
        }

        val people = client.getPeople(1)

        assertNotNull(people)
        assertEquals("172", people.height)
        assertEquals("Luke Skywalker", people.name)
        assertEquals("blue", people.eyeColor)

    }

    @Test
    fun `The Phantom Menace can be serialized`() = runBlocking {

        val mockEngine = MockEngine {

            respond(
                status = HttpStatusCode.OK,
                headers = headersOf(
                    Pair(HttpHeaders.ContentType, listOf("application/json"))
                ),
                content = THE_PHANTOM_MENACE
            )

        }

        val client = swapiClient {
            engine = mockEngine
        }

        val film = client.getFilm(1)

        assertNotNull(film)
        assertEquals("The Phantom Menace", film.title)
        assertEquals("George Lucas", film.director)
        assertEquals("Rick McCallum", film.producer)

    }

    @Test
    fun `Hoth can be serialized`() = runBlocking {

        val mockEngine = MockEngine {

            respond(
                status = HttpStatusCode.OK,
                headers = headersOf(
                    Pair(HttpHeaders.ContentType, listOf("application/json"))
                ),
                content = PLANET_HOTH
            )

        }

        val client = swapiClient {
            engine = mockEngine
        }

        val planet = client.getPlanet(1)

        assertNotNull(planet)
        assertEquals("Hoth", planet.name)
        assertEquals("23", planet.rotationPeriod)
        assertEquals("549", planet.orbitalPeriod)
        assertEquals("7200", planet.diameter)

    }


}
