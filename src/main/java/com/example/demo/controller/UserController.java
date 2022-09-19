package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

	// private static final Logger
	// logger=LoggerFactory.getLogger(UserController.class);
	// writes>>logger.info("In login service method");

	@Autowired
	private UserService userService;

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		User saveUser = this.userService.saveUser(user);
		return ResponseEntity.ok(saveUser);

	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = this.userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}

	@GetMapping("/byid/{userId}")
	public ResponseEntity<Optional<User>> getUserbyId(@RequestBody @PathVariable Integer userId) {
		Optional<User> userbyId = this.userService.getUserbyId(userId);
		return ResponseEntity.ok(userbyId);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<User> updateUserbyId(@RequestBody User user, @PathVariable Integer userId) {
		User updateUserbyId = this.userService.updateUserbyId(user, userId);
		return ResponseEntity.ok(updateUserbyId);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> deleteUserbyId(@RequestBody @PathVariable Integer userId) {
		this.userService.deleteUserbyId(userId);
		return ResponseEntity.ok("Record deleted sucessfully");
	}

	@GetMapping("/name/{userName}")
	public ResponseEntity<List<User>> getUserbyName(@RequestBody @PathVariable String userName) {
		List<User> userbyName = this.userService.getUserbyName(userName);
		return ResponseEntity.ok(userbyName);
	}

	@GetMapping("/city/{userCity}")
	public ResponseEntity<List<User>> getUserbyCity(@RequestBody @PathVariable String userCity) {
		List<User> userbyCity = this.userService.getUserbyCity(userCity);
		return ResponseEntity.ok(userbyCity);
	}
}