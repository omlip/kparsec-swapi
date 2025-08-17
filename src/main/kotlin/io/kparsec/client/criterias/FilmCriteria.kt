package io.kparsec.client.criterias

class FilmCriteria {

    var title: String = ""

    infix fun String.has(value: String) {
        title = value
    }

    infix fun String.matching(value: String) {
        title = value
    }

}
