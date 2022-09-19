package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserService {

	public User saveUser(User user);

	public List<User> getAllUsers();

	public Optional<User> getUserbyId(Integer userId);

	public User updateUserbyId(User user, Integer userId);

	public void deleteUserbyId(Integer userId);

	public List<User> getUserbyName(String userName);

	public List<User> getUserbyCity(String userCity);
}