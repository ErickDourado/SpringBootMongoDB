package com.erickdourado.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erickdourado.springbootmongo.domain.User;
import com.erickdourado.springbootmongo.dto.UserDTO;
import com.erickdourado.springbootmongo.repositories.UserRepository;
import com.erickdourado.springbootmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id); //Só pra ver se acha, se não achar lança exception.
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());//pegando o user antigo pelo id pra dps atualizar.
		updateData(newUser, user);
		return repository.save(newUser);
	}
	
	public User fromDTO(UserDTO dto) {
		//método criado para transformar UserDTO em User
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}
	
	public void updateData(User antigo, User novo) {
		antigo.setName(novo.getName());
		antigo.setEmail(novo.getEmail());
	}
}