package com.example.UserService2.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserService2.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User save(User user);

	Optional<User> findByEmail(String email);

}
