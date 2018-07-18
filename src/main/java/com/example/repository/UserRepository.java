package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);

}