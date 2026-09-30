# Lesson 01: pom.xml, parent, and the BOM

## Concept
- spring-boot-starter-parent (4.1.1) is Spring Boot's config, not Spring Framework.
- It acts as a Bill of Materials (BOM): one tested set of compatible library versions.
- Dependencies have no <version> because the parent supplies it. It is FIXED per Boot version, not "latest".
- Boot 4: web starter is spring-boot-starter-webmvc (older tutorials say starter-web).
- java.version is the compile TARGET, not the JDK you must run. JDK 25 can build for 21.

## What breaks
- Pinning a random newer library version overrides the BOM: you now own compatibility testing.
- Failure is a classloading error (NoSuchMethodError / ClassNotFoundException) when the mismatched code first runs.
- Can be at startup OR mid-request on a rarely used path: dependency hell.

## Comprehension check: passed
