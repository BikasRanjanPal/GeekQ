package com.geekq.api.gateway.service.accesscontrol.aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geekq.api.gateway.model.Answer;
import com.geekq.api.gateway.service.accesscontrol.AccessControlService;

@Aspect
@Component
public class AccessControlAspectsAnswer {

	@Autowired
	private AccessControlService<Answer> accessControlService;

	public void setAccessControlService(AccessControlService<Answer> accessControlService) {
		this.accessControlService = accessControlService;
	}

	@Around("execution(* com.geekq.api.gateway.repository.AnswerRepository.save(..)) && args(answer)")
	public Object save(ProceedingJoinPoint proceedingJoinPoint, Answer answer) throws Throwable {
		if (answer.getId() == null) {
			accessControlService.canCurrentUserCreateObject(answer);
		} else {
			accessControlService.canCurrentUserUpdateObject(answer);
		}

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.geekq.api.gateway.repository.AnswerRepository.find(Long)) && args(id)")
	public Object find(ProceedingJoinPoint proceedingJoinPoint, Long id) throws Throwable {
		accessControlService.canCurrentUserReadObject(id);

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.geekq.api.gateway.repository.AnswerRepository.findAll())")
	public Object findAll(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		accessControlService.canCurrentUserReadAllObjects();

		return proceedingJoinPoint.proceed();
	}

	@Around("execution(* com.geekq.api.gateway.repository.AnswerRepository.delete(..)) && args(answer)")
	public Object delete(ProceedingJoinPoint proceedingJoinPoint, Answer answer) throws Throwable {
		accessControlService.canCurrentUserDeleteObject(answer);

		return proceedingJoinPoint.proceed();
	}

}