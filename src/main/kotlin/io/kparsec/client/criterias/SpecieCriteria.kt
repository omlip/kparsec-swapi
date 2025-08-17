package io.kparsec.client.criterias

class SpecieCriteria {
    lateinit var name: String

    infix fun String.matching(value: String) {
        name = value
    }

}
