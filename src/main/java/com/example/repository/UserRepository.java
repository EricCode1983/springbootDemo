package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAll();
	User findByUserName(String userName);

	User findByUserNameOrEmail(String username, String email);


	List<User> findByEmailLike(String email);


	@Modifying
	@Transactional
	@Query("update User u set u.email = ?2 where u.id = ?1")
	int modifyEmail1( Long id,String  email);

	@Transactional
	@Modifying
	@Query("delete from User where id = ?1")
	void deleteByUserId(Long id);

	@Transactional(timeout = 10)
	@Query("select u from User u where u.emailAddress = ?1")
	User findByEmailAddress(String emailAddress);
}