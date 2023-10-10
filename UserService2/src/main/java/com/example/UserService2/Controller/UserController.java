package com.example.UserService2.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService2.DTO.CreateUserDetailDTO;
import com.example.UserService2.DTO.VerifyUserDTO;
import com.example.UserService2.Model.User;
import com.example.UserService2.Services.UserService;

@RestController
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/user")
	User createUser(@RequestBody CreateUserDetailDTO request) {
		User user = this.userService.createUser(request.getEmail(), request.getPassword());
		return user;
	}

	@PostMapping("/user/verifyUser")
	public boolean verifyUser(@RequestBody VerifyUserDTO request) {
		boolean verify = this.userService.verifyUser(request.getEmail(), request.getPassword());
		return verify;

	}
}
