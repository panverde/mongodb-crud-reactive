package com.reactiva.demomongodbreact.controller;

import com.reactiva.demomongodbreact.model.User;
import com.reactiva.demomongodbreact.service.IUserService;
import com.reactiva.demomongodbreact.service.impl.UserServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService service;

    @GetMapping
    public Flux<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<User> findOne(@PathVariable String id) {
        log.debug("findOne Blog with id : {}", id);
        return service.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser(@RequestBody User user){
        log.debug("Create User");
        return service.createUser(user);
    }

    @PutMapping("/{id}")
    public Mono<User> updateUser(@RequestBody User user, @PathVariable String id) {
        log.debug("updateBlog Blog with id : {} and blog : {}", id, user);
        return service.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteById(@PathVariable String id){
        log.debug("delete By Id : {}",id);
        return service.delete(id);
    }

}
