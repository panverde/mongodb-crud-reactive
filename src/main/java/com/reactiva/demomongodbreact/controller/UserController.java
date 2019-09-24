package com.reactiva.demomongodbreact.controller;

import com.reactiva.demomongodbreact.model.User;
import com.reactiva.demomongodbreact.service.IUserService;
import com.reactiva.demomongodbreact.service.impl.UserServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserService service;

    @GetMapping
    public Flux<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findOne(@PathVariable String id) {
        //log.debug("findOne Blog with id : {}", id);
        return service.findOne(id);
    }

}
