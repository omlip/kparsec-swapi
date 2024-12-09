import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

abstract class SwapiItem {
    @Serializable(with = InstantIso8601Serializer::class) abstract val created: Instant
    @Serializable(with = InstantIso8601Serializer::class) abstract val edited: Instant
    abstract val url: String
}

@Serializable
data class People(
    val name: String,
    val height: String,
    val mass: String,
    @SerialName("hair_color") val hairColor: String,
    @SerialName("skin_color") val skinColor: String,
    @SerialName("eye_color") val eyeColor: String,
    @SerialName("birth_year") val birthYear: String,
    val gender: String,
    val films: List<String>,
    val species: List<String>,
    val starships: List<String>,
    val vehicles: List<String>,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class Planet(
    val name: String,
    @SerialName("rotation_period") val rotationPeriod: String,
    @SerialName("orbital_period") val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    @SerialName("surface_water") val surfaceWater: String,
    val population: String,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class Starship(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerialName("cost_in_credits") val costInCredits: String,
    val length: String,
    @SerialName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerialName("cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    @SerialName("hyperdrive_rating") val hyperdriveRating: String,
    @SerialName("MGLT") val mglt: String,
    @SerialName("starship_class") val starshipClass: String,
    val films: List<String>,
    val pilots: List<String>,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class Vehicle(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerialName("cost_in_credits") val costInCredits: String,
    val length: String,
    @SerialName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    val crew: String,
    val passengers: String,
    @SerialName("cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    @SerialName("vehicle_class") val vehicleClass: String,
    val films: List<String>,
    val pilots: List<String>,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class Film(
    val title: String,
    @SerialName("episode_id") val episodeId: Int,
    @SerialName("opening_crawl") val openingCrawl: String,
    val director: String,
    val producer: String,
    @SerialName("release_date") val releaseDate: String,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class Specie(
    val name: String,
    val classification: String,
    val designation: String,
    @SerialName("average_height") val averageHeight: String,
    @SerialName("skin_colors") val skinColors: String,
    @SerialName("hair_colors") val hairColors: String,
    @SerialName("eye_colors") val eyeColors: String,
    @SerialName("average_lifespan") val averageLifespan: String,
    val homeworld: String?,
    val language: String,
    val people: List<String>,
    val films: List<String>,
    override val created: Instant,
    override val edited: Instant,
    override val url: String
): SwapiItem()

@Serializable
data class SearchResponse<T : SwapiItem>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)

