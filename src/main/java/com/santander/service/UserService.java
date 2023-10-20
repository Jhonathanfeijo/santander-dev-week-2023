package com.santander.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public User create(User userRequest) {
		valideUser(userRequest);
		return userRepository.save(userRequest);
	}

	public void delete(Long id) {
		if (!userRepository.existsById(id))
			throw new UserNotFoundException();
		userRepository.deleteById(id);
	}

	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
	}

	public Page<User> getUsers(Pageable pageable) {
		return userRepository.findAll(pageable);
	}

	public User update(Long id, User user) {
		if (!userRepository.existsById(id))
			throw new UserNotFoundException();
		valideUser(user);
		user.setId(id);
		return userRepository.save(user);
	}
	
	private void valideUser(User user) {
		validations.forEach(v -> v.validar(user));
	}
}
