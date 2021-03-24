package com.geekq.api.gateway.service.usermanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekq.api.gateway.exceptions.UserAlreadyExistsException;
import com.geekq.api.gateway.model.RegistrationToken;
import com.geekq.api.gateway.model.TokenType;
import com.geekq.api.gateway.model.User;
import com.geekq.api.gateway.service.UserService;
import com.geekq.api.gateway.service.usermanagement.token.TokenDeliverySystem;
import com.geekq.api.gateway.service.usermanagement.token.TokenServiceRegistration;

@Service
public class RegistrationServiceMail implements RegistrationService {

	private UserService userService;
	private TokenServiceRegistration tokenService;
	private TokenDeliverySystem tokenDeliveryService;

	@Autowired
	public RegistrationServiceMail(UserService userService, TokenServiceRegistration tokenService,
			TokenDeliverySystem tokenDeliveryService) {
		this.userService = userService;
		this.tokenService = tokenService;
		this.tokenDeliveryService = tokenDeliveryService;
	}

	@Override
	public User startRegistration(User user) {
		User newUser;

		try {
			newUser = userService.saveUser(user);
		} catch (UserAlreadyExistsException e) {
			newUser = userService.findByEmail(user.getEmail());
			if (userService.isRegistrationCompleted(newUser)) {
				throw e;
			}
		}

		RegistrationToken mailToken = tokenService.generateTokenForUser(newUser);
		tokenDeliveryService.sendTokenToUser(mailToken, newUser, TokenType.REGISTRATION_MAIL);

		return newUser;
	}

	@Override
	public User continueRegistration(User user, String token) {
		tokenService.validateTokenForUser(user, token);

		userService.setRegistrationCompleted(user);
		tokenService.invalidateToken(token);

		return user;
	}

	@Override
	public boolean isRegistrationCompleted(User user) {
		return userService.isRegistrationCompleted(user);
	}

}
