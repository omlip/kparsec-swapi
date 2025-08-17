package io.kparsec.client.criterias

class PeopleCriteria {

    var name: String = ""

    infix fun String.matching(value: String) {
        name = value
    }
}
