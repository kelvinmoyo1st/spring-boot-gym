# Lesson 01 Exercise: bean ambiguity

## What happened
- Two @Repository beans implementing one interface: startup failed with
  "Parameter 0 of constructor in TransferService required a single bean, but 2 were found".
- Failed at container wiring (before any request), not at request time.
- Compile error (missing import) is a different phase: Maven fails before Spring launches.

## The fix pattern
- @Primary on the implementation class = author's default for everyone.
- @Qualifier("beanName") at the injection point = one consumer's explicit choice.
- Bean name = class name with lowercase first letter.

## Review notes
- Stubs belong in src/test, not src/main.
- @Qualifier strings are magic strings: rename breaks at startup, not compile time.
- @Primary on the stub would silently switch every consumer to fake data.
