package com.gym.lesson01;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class InMemoryAccountRepository implements AccountRepository {
    @Override
    public String findOwner(int id) {
        return "in-memory owner " + id;
    }
}
