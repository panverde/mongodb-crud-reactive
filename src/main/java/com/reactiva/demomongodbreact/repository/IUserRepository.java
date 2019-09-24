package com.reactiva.demomongodbreact.repository;

import com.reactiva.demomongodbreact.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IUserRepository extends ReactiveMongoRepository<User,String> {
   Mono<User> findByUserIdAndDeleteIsFalse(String id);

}
