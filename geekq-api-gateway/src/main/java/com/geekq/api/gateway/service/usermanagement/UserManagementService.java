package com.geekq.api.gateway.service.usermanagement;
import com.geekq.api.gateway.model.User;

public interface UserManagementService {

	void resendPassword(User user);

	void verifyResetPasswordToken(User user, String token);

	void updatePassword(User user, String password);

}