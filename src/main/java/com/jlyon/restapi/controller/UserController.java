package com.jlyon.restapi.controller;

import com.jlyon.restapi.accessor.UserAccessor;
import com.jlyon.restapi.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserAccessor accessor;

	@GetMapping
	public List<User> queryUsers() {
//		throw new RuntimeException();
		return accessor.getAll();
	}

	@GetMapping("/{userId}")
	public List<User> getOneById(@PathVariable UUID userId) {
		return Collections.singletonList(accessor.getOneById(userId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody User newUser) {
		return accessor.createOne(newUser);
	}
}
