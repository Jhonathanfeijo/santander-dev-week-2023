package com.santander.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.santander.domain.model.User;
import com.santander.domain.repository.UserRepository;
import com.santander.domain.service.UserService;
import com.santander.domain.service.exception.UserNotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@Transactional
	public ResponseEntity<User> inserirUser(@RequestBody @Valid User user, UriComponentsBuilder builder) {
		user = userService.inserirUser(user);
		URI uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@GetMapping
	public ResponseEntity<Page<User>> buscarUsers(@PageableDefault(size = 10) Pageable pageable) {
		Page<User> users = userService.buscarUsers(pageable);
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> buscarUser(@PathVariable("id") Long id) {
		User user = userService.buscarUser(id);
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletarUser(@PathVariable("id") Long id) {
		userService.deletarUser(id);
		return ResponseEntity.noContent().build();
	}
}
