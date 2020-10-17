package com.jlyon.restapi.accessor;

import com.jlyon.restapi.entity.User;
import com.jlyon.restapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserAccessor {
	@Autowired
	private UserRepository repository;

	public User createOne(User newUser) {
		return repository.save(newUser);
	}

	public List<User> getAll() {
		return repository.findAll();
	}

	public User getOneById(UUID id) {
		return repository.getOne(id);
	}

	public User getOneByEmail(String email) {
		return repository.findOneByEmail(email);
	}

	public User updateUser(User newUser) {
		return repository.getOne(newUser.getId());
	}
}
