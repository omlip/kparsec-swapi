![Build](https://img.shields.io/github/actions/workflow/status/omlip/kparsec-swapi/ci.yml?branch=main)
![Kotlin](https://img.shields.io/badge/kotlin-2.2.0-blue.svg?logo=kotlin)
![License](https://img.shields.io/github/license/<OWNER>/<REPO>)
![GitHub stars](https://img.shields.io/github/stars/<OWNER>/<REPO>?style=social)

# 🌌 KParsec-SWAPI Client

> “Traveling through hyperspace ain't like dusting crops, boy.”  
> — Han Solo

A **pure Kotlin client** for the [Star Wars API (SWAPI)](https://swapi.tech/).  
This project started as a **learning exercise** to explore Kotlin basics, coroutines, and Ktor, while also delivering a fully functional REST client for interacting with the galaxy far, far away at Kotlin speed.

---

## ✨ Features

- Written in **pure Kotlin**
- Uses **Ktor HTTP client** with:
    - JSON (Kotlinx serialization)
    - Retries & timeouts
    - Built-in caching
- Supports fetching:
    - People
    - Planets
    - Films
    - Vehicles
    - Starships
    - Species
- Search endpoints with criteria builders (e.g. search by name, title, or model)
- Configurable client (host, timeout, retries, debug logging)

---

## 🚀 Getting Started

### Installation

Add the dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("io.kparsec:swapi-client:<version>")
}
```
(Note: library publishing is still work-in-progress. For now, clone and build locally.)

### Usage
```kotlin
import io.kparsec.client.SwapiClient
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val client = SwapiClient()

    val luke = client.getPeople(1)
    println("Name: ${luke?.name}") // "Luke Skywalker"

    val films = client.films { title = "Hope" }
    println("Found films: ${films.result.size}")
}
```

### Configuration
```kotlin
val client = SwapiClient.swapiClient {
    apiUrl = "swapi.info"
    retry = 5
    timeout = 15_000
    debug = true
}
```

## 🧪 Testing

The project includes tests using Ktor’s `MockEngine` to verify:

- Correct endpoints & query parameters
- JSON deserialization (ignores unknown fields)
- Handling of HTTP statuses (`200`, `204`, `404`, etc.)
- Retry & timeout behavior
- Error propagation with a custom `GalaxyException`

---

## 🌠 Roadmap

- [ ] Publish to Maven Central
- [ ] Expand models to cover **all SWAPI resources**
- [ ] Add DSL sugar for more complex queries
- [ ] Improve error reporting with structured responses
- [ ] Example CLI app (so you can ask Yoda for wisdom from the terminal)

---

## 🤝 Contributing

Pull requests are welcome!  
If you find a bug or have an idea, open an issue.  
Remember: *“The Force will be with you, always.”*

---

## 📜 License

MIT License. See [LICENSE](./LICENSE) for details.  


