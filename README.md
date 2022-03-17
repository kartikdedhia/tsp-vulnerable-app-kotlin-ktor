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

| Vulnerability Type                                                           | Description                                                                                                                                                                       | Location                                                                                    | PoC Command                                                          |
|------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| [Cross Site Scripting (XSS)](https://cwe.mitre.org/data/definitions/79.html) | The `/hello` endpoint generates page output in code. It expects a name as a parameter to say `"Hello, $name"` and just concatenates user input to the output without escaping it. | `call.respondText("Hello, ${call.request.queryParameters["name"]}", ContentType.Text.Html)` | <http://localhost:8080/hello?name=%3Cscript%3Ealert(1)%3C/script%3E> | 
| [Cross Site Scripting (XSS)](https://cwe.mitre.org/data/definitions/79.html) | The `/view` endpoint uses a template engine to say `"Hello, $name"` and misuses template engine syntax leaving the user input unescaped.                                          | `<p>Hello, <span th:utext="${name}"></span></p>`                                            | <http://localhost:8080/view?name=%3Cscript%3Ealert(1)%3C/script%3E>  | 

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
