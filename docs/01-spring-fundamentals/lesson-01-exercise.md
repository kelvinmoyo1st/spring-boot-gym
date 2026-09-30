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

## Result of the experiment
- Predicted: in-memory owner. Observed: stub owner.
- Reason: @Qualifier at the injection point beats @Primary.
- @Primary is only the default when a consumer does not say what it wants.

## Vocabulary
- TransferService DEPENDS ON an AccountRepository. It does not implement it.
- InMemoryAccountRepository and StubAccountRepository IMPLEMENT AccountRepository.

## Sequence: wiring vs requests

Startup (once):

    Container creates inMemoryAccountRepository (@Primary)
    Container creates stubAccountRepository
    Container creates TransferService
        -> constructor asks for "stubAccountRepository" (@Qualifier wins)
    Container creates OwnerController
        -> constructor gets the TransferService

Request (every time):

    GET /owner/1
     -> Tomcat -> Spring MVC -> OwnerController.owner(1)
     -> TransferService.owner(1)
     -> stubAccountRepository.findOwner(1)
     -> "stub owner 1"

- Wiring happens once at startup. Requests just follow the wires.
- Any other service without @Qualifier would get the @Primary in-memory bean.
