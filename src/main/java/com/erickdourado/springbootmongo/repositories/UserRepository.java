package com.erickdourado.springbootmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erickdourado.springbootmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
