package com.example.UserService.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.UserService.Model.User;
import com.example.UserService.Repository.UserRepository;

@Service
public class UserService {
	@Value("${server.port}")
	private String port;

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		User user_ans = userRepository.save(user);
		return user_ans;
	}

	public boolean verifyUser(String email, String password) {
		System.out.println("Request to verify user at port: " + port);
		Optional<User> user = this.userRepository.findByEmail(email);
		if (user.isEmpty())
			return false;
		User user_ans = user.get();
		if (!user_ans.getPassword().equals(password))
			return false;
		return true;
	}
}
