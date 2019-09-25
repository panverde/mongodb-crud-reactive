package com.reactiva.demomongodbreact.service.impl;

import com.reactiva.demomongodbreact.model.User;
import com.reactiva.demomongodbreact.repository.IUserRepository;
import com.reactiva.demomongodbreact.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> createUser(User user) {
        return userRepository.insert(user);
    }

    @Override
    public Mono<User> updateUser(User user, String id) {
        return findOne(id).doOnSuccess(findUser ->{
            findUser.setName(user.getName());
            findUser.setCreationDate(user.getCreationDate());
            findUser.setUserSettings(user.getUserSettings());
            userRepository.save(findUser).subscribe();
        });
    }
    @Override
    public Mono<User> findOne(String id) {
       return userRepository.findById(id) //findByUserIdAndDeleteIsFalse
                .switchIfEmpty(Mono.error(new Exception("No User found with Id: " + id)));
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return userRepository.deleteById(id)
                .flatMap(user->Mono.just(Boolean.TRUE));
    }


}
