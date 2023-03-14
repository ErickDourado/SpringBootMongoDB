package com.erickdourado.springbootmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.erickdourado.springbootmongo.domain.Post;
import com.erickdourado.springbootmongo.domain.User;
import com.erickdourado.springbootmongo.dto.AuthorDTO;
import com.erickdourado.springbootmongo.repositories.PostRepository;
import com.erickdourado.springbootmongo.repositories.UserRepository;
	
@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, Instant.parse("2018-03-21T00:04:00.00Z"), "Partiu Viagem", 
				"Vou viajar para São Paulo, Abraços!", new AuthorDTO(maria));
		
		Post post2 = new Post(null, Instant.parse("2018-11-30T00:04:00.00Z"), "Bom dia", "Acordei feliz hoje!", 
				new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
