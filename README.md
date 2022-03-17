# A sample application with known vulnerabilities - Kotlin, Ktor

A sample application with known issues for testing various linters, scanners,
and scan automation.

This project uses:

| Component   | In Use                                                  | 
|-------------|---------------------------------------------------------|
| Platform    | JVM ([Java Virtual Machine](https://openjdk.java.net/)) |
| Language(s) | [Kotlin](https://kotlinlang.org/)                       |
| Build       | [Gradle](https://gradle.org/)                           |
| Framework   | [Ktor](https://ktor.io/)                                |

## Security issues

| Vulnerability Type | Description | Location | PoC Command |
|--------------------|-------------|----------|-------------|
| --                 | --          | --       | --          |

### Other issues

* The project has no tests

## Running this code

**NOTE: This project contains security vulnerabilities and should be only run in
testing purposes.**

Requirements:

* [JDK](https://openjdk.java.net/)
* [Gradle](https://gradle.org/)

To run the code locally:

```shell
# Clone the project
git clone https://github.com/the-scan-project/tsp-vulnerable-app-kotlin-ktor.git
cd tsp-vulnerable-app-kotlin-ktor

# Start the application
gradle run
```
