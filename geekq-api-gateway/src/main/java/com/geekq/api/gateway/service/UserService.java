package com.geekq.api.gateway.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.geekq.api.gateway.exceptions.ResourceUnavailableException;
import com.geekq.api.gateway.exceptions.UnauthorizedActionException;
import com.geekq.api.gateway.exceptions.UserAlreadyExistsException;
import com.geekq.api.gateway.model.User;

public interface UserService extends UserDetailsService {
	User saveUser(User user) throws UserAlreadyExistsException;

	User find(Long id) throws ResourceUnavailableException;;

	User findByEmail(String email) throws ResourceUnavailableException;

	User findByUsername(String username) throws ResourceUnavailableException;

	User updatePassword(User user, String password) throws ResourceUnavailableException;

	void delete(Long user_id) throws UnauthorizedActionException, ResourceUnavailableException;

	User setRegistrationCompleted(User user) throws ResourceUnavailableException;

	boolean isRegistrationCompleted(User user) throws ResourceUnavailableException;

}