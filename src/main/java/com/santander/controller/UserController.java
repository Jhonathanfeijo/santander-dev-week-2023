package com.santander.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.santander.controller.exception.user.UserNotFoundException;
import com.santander.domain.model.User;
import com.santander.domain.repository.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<User> inserirUser(@RequestBody @Valid User user, UriComponentsBuilder builder) {
		user = userRepository.save(user);
		URI uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}

	@GetMapping
	public ResponseEntity<Page<User>> buscarUsers(Pageable paginacao) {
		Page<User> users = userRepository.findAll(paginacao);
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> buscarUser(@PathVariable("id") Long id) {
		User user = userRepository.findById(id).get();
		return ResponseEntity.ok().body(user);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletarUser(@PathVariable("id") Long id) {
		if (!userRepository.existsById(id))
			throw new UserNotFoundException();
		userRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
