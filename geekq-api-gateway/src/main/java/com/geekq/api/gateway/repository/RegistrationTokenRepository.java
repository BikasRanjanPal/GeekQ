package com.geekq.api.gateway.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.geekq.api.gateway.model.RegistrationToken;

@Repository
public interface RegistrationTokenRepository extends TokenRepository<RegistrationToken> {
	@Modifying
	@Query("delete from RegistrationToken t where t.expirationDate <= ?1")
	void deletePreviousTo(Date date);
}