package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	

	@Override
	public User saveUser(User user) {
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	@Override
	public Optional<User> getUserbyId(Integer userId) {
		return this.userRepository.findById(userId);

	}

	@SuppressWarnings("deprecation")
	@Override
	public User updateUserbyId(User user, Integer userId) {
		User byId = this.userRepository.getById(userId);
		byId.setName(user.getName());
		byId.setCity(user.getCity());
		User save = this.userRepository.save(byId);
		return save;
	}

	@Override
	public void deleteUserbyId(Integer userId) {
		this.userRepository.deleteById(userId);
	}

	@Override
	public List<User> getUserbyName(String userName) {
		return this.userRepository.getUserbyName(userName);
	}

	@Override
	public List<User> getUserbyCity(String userCity) {
		return this.userRepository.getUserbyCity(userCity);
	}
}