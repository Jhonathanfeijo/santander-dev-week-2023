package com.santander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.santander.domain.model.User;
import com.santander.domain.repository.UserRepository;
import com.santander.service.exception.UserNotFoundException;
import com.santander.service.validations.user.UserValidation;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private List<UserValidation> validations;

	public User inserirUser(User userRequest) {
		validations.forEach(v -> v.validar(userRequest));
		User user = userRepository.save(userRequest);
		return user;
	}

	public void deletarUser(Long id) {
		if (!userRepository.existsById(id))
			throw new UserNotFoundException();
		userRepository.deleteById(id);
	}

	public User buscarUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
	}

	public Page<User> buscarUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
}
