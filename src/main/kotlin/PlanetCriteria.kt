class PlanetCriteria {

    lateinit var name: String

    infix fun String.matching(value: String) {
        name = value
    }
}
