# Lesson 01: Starters, transitive deps, embedded server

## Concept
- starter-webmvc pulls in Spring MVC, embedded Tomcat, Jackson, base starter (container, logging, autoconfig) transitively.
- Tomcat runs embedded in the app: no separate server install.
- spring-boot-maven-plugin builds one executable fat jar (java -jar).
- Test starter has :test scope, so it is not shipped in production.

## Why it works
- Tomcat and Jetty both implement the Servlet API. Spring MVC targets that standard, so controllers never depend on the server.

## What breaks
- Swap servers: exclude starter-tomcat AND add starter-jetty. Skipping the exclusion puts two servers on the classpath.
- Boot 4 uses Jackson 3 (tools.jackson). Boot 3 tutorial imports (com.fasterxml.jackson.databind) will not compile. Read the exact import in the error.
- Boot 4 web starter is starter-webmvc, not starter-web.

## Comprehension check: passed
