package com.geekq.api.gateway.service.usermanagement.token;
import java.util.Date;

import com.geekq.api.gateway.exceptions.InvalidTokenException;
import com.geekq.api.gateway.model.TokenModel;
import com.geekq.api.gateway.model.User;

public interface TokenService<T extends TokenModel> {
	T generateTokenForUser(User user);

	void validateTokenForUser(User user, String token) throws InvalidTokenException;

	void invalidateToken(String token);

	void invalidateExpiredTokensPreviousTo(Date date);
}