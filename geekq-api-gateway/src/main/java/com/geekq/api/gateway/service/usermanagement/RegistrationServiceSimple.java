package com.geekq.api.gateway.service.usermanagement;
import org.springframework.beans.factory.annotation.Autowired;

import com.geekq.api.gateway.model.User;
import com.geekq.api.gateway.service.UserService;

public class RegistrationServiceSimple implements RegistrationService {

	@Autowired
	private UserService userService;

	@Override
	public User startRegistration(User user) {
		User newUser = userService.saveUser(user);
		userService.setRegistrationCompleted(newUser);

		return newUser;
	}

	@Override
	public User continueRegistration(User user, String token) {
		return null;
	}

	@Override
	public boolean isRegistrationCompleted(User user) {
		return userService.isRegistrationCompleted(user);
	}

}