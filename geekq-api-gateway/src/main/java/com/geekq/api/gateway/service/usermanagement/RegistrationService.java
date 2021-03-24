package com.geekq.api.gateway.service.usermanagement;
import com.geekq.api.gateway.model.User;

public interface RegistrationService {
	User startRegistration(User user);

	User continueRegistration(User user, String token);

	boolean isRegistrationCompleted(User user);
}
