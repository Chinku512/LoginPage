package com.example.ZZlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ZZlogin.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String emailId);

	//User saveUser(User user);




}
