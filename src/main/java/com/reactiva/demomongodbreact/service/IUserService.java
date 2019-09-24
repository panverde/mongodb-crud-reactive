package com.reactiva.demomongodbreact.service;

import com.reactiva.demomongodbreact.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {
    Flux<User> findAll();
    Mono<User> createUser(User user);
    Mono<User> updateUser(User user, String id);
    Mono<User> findOne(String id);
    Mono<Boolean> delete(String id);
}
