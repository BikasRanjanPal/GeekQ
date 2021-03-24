package com.geekq.api.gateway.service.accesscontrol.aspects;
import org.aspectj.lang.ProceedingJoinPoint;

import com.geekq.api.gateway.model.BaseModel;

public interface AccessControlAspects<T extends BaseModel> {
	Object save(ProceedingJoinPoint proceedingJoinPoint, T object) throws Throwable;

	Object find(ProceedingJoinPoint proceedingJoinPoint, Long id) throws Throwable;

	Object findAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable;

	Object delete(ProceedingJoinPoint proceedingJoinPoint, T object) throws Throwable;
}