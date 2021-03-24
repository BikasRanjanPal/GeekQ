package com.geekq.api.gateway.service.usermanagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geekq.api.gateway.model.ForgotPasswordToken;
import com.geekq.api.gateway.model.TokenType;
import com.geekq.api.gateway.model.User;
import com.geekq.api.gateway.service.UserService;
import com.geekq.api.gateway.service.usermanagement.token.TokenDeliverySystem;
import com.geekq.api.gateway.service.usermanagement.token.TokenServiceForgotPassword;

@Service
public class UserManagementServiceImpl implements UserManagementService {

	private UserService userService;
	private TokenServiceForgotPassword forgotPasswordService;
	private TokenDeliverySystem tokenDeliveryService;

	@Autowired
	public UserManagementServiceImpl(UserService userService, TokenServiceForgotPassword forgotPasswordService,
			TokenDeliverySystem tokenDeliveryService) {
		this.forgotPasswordService = forgotPasswordService;
		this.tokenDeliveryService = tokenDeliveryService;
		this.userService = userService;
	}

	@Override
	public void resendPassword(User user) {
		ForgotPasswordToken token = forgotPasswordService.generateTokenForUser(user);
		tokenDeliveryService.sendTokenToUser(token, user, TokenType.FORGOT_PASSWORD);
	}

	@Override
	public void verifyResetPasswordToken(User user, String token) {
		forgotPasswordService.validateTokenForUser(user, token);
	}

	@Override
	public void updatePassword(User user, String password) {
		userService.updatePassword(user, password);
	}

}