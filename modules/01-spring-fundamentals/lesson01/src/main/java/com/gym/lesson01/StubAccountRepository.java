package com.gym.lesson01;

import org.springframework.stereotype.Repository;

@Repository
public class StubAccountRepository implements AccountRepository {
    @Override
    public String findOwner(int id) {
        return "stub owner " + id;
    }
}
