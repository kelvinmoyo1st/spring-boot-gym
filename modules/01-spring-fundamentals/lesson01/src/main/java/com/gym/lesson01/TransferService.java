package com.gym.lesson01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TransferService {

    private final AccountRepository repo;

    public TransferService(@Qualifier("stubAccountRepository") AccountRepository repo) {
        this.repo = repo;
    }

    public String owner(int id) {
        return repo.findOwner(id);
    }
}
