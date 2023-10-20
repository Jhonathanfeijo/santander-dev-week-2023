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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.santander.controller.dto.UserDto;
import com.santander.domain.model.User;
import com.santander.service.UserService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@Transactional
	public ResponseEntity<UserDto> create(@RequestBody @Valid UserDto userDto, UriComponentsBuilder builder) {
		User user = userService.create(userDto.toUser());
		URI uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDto(user));
	}

	@GetMapping
	public ResponseEntity<Page<UserDto>> getUsers(@PageableDefault (size = 10) Pageable pageable) {
		Page<UserDto> users = userService.getUsers(pageable).map(user -> new UserDto(user));
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
		User user = userService.getUser(id);
		return ResponseEntity.ok().body(new UserDto(user));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable("id") Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody @Valid UserDto userDto) {
		User user = userService.update(id, userDto.toUser());
		return ResponseEntity.ok(new UserDto(user));
	}
}
