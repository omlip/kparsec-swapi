class VehicleCriteria {
    lateinit var nameOrModel: String

    infix fun String.matching(value: String) {
        nameOrModel = value
    }

}