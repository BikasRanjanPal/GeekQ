package com.geekq.api.gateway.service.accesscontrol;
import org.springframework.stereotype.Service;

import com.geekq.api.gateway.exceptions.UnauthorizedActionException;
import com.geekq.api.gateway.model.AuthenticatedUser;
import com.geekq.api.gateway.model.Quiz;

@Service("AccessControlQuiz")
public class AccessControlServiceQuiz extends AccessControlServiceUserOwned<Quiz> {

	/*
	 * As long as the user is authenticated, it can create a Quiz.
	 */
	@Override
	public void canUserCreateObject(AuthenticatedUser user, Quiz object) throws UnauthorizedActionException {
		if (user == null) {
			throw new UnauthorizedActionException();
		}
	}

}
