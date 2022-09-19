package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
	@Query(value = "select * from User where name=?",nativeQuery = true)
	public List<User> getUserbyName(String userName);
	
	
	@Query(value = "select * from User where city=?",nativeQuery = true)
	public List<User> getUserbyCity(String userCity);
}