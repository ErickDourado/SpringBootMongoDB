package com.erickdourado.springbootmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erickdourado.springbootmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
