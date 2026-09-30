# Lesson 01: IoC and Dependency Injection

## Concept
- IoC: a class stops controlling who creates its dependencies. The Spring container does.
- DI: the container builds beans and passes them in, preferably via the constructor.
- Beans are singletons by default: one shared instance.

## Why it works
- Container builds all beans at startup, then reuses them.
- Constructor + final field = object is fully built or not built at all.
- Depending on interfaces lets us swap real and fake implementations.

## What breaks
- `new` inside a class: tests can't swap in a fake (e.g. real bank API in tests).
- Field injection: no constructor to pass a fake into, so tests need Spring booted or reflection.
- Two beans of the same type: startup fails (NoUniqueBeanDefinitionException). Good: a loud crash beats silently picking the wrong one (test stub vs real money).
- Fix with @Primary or @Qualifier.
- Mutable state in a singleton: race condition, lost update (5 -> two increments -> 6, not 7). Silent, no stack trace.
- Fix: keep services stateless, put state in the database.

## Comprehension check: passed
- Q1 IoC, Q2 who builds beans, Q3 ambiguity, Q4 final + testability, Q5 concurrency.
