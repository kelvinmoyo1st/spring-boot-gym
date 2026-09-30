package com.gym.lesson01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController {
    private final TransferService service;

    public OwnerController(TransferService service) {
        this.service = service;
    }

    @GetMapping("/owner/{id}")
    public String owner(@PathVariable int id) {
        return service.owner(id);
    }
}
