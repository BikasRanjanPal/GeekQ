package com.geekq.api.gateway.service.usermanagement.token;
import org.springframework.scheduling.annotation.Async;

import com.geekq.api.gateway.model.TokenModel;
import com.geekq.api.gateway.model.TokenType;
import com.geekq.api.gateway.model.User;

public interface TokenDeliverySystem {
	@Async
	void sendTokenToUser(TokenModel token, User user, TokenType tokenType);
}