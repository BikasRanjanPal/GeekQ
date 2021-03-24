package com.geekq.api.gateway.service;

import java.util.List;

import com.geekq.api.gateway.exceptions.ResourceUnavailableException;
import com.geekq.api.gateway.exceptions.UnauthorizedActionException;
import com.geekq.api.gateway.model.Answer;
import com.geekq.api.gateway.model.Question;

public interface AnswerService {
	Answer save(Answer answer) throws UnauthorizedActionException;

	Answer find(Long id) throws ResourceUnavailableException;

	Answer update(Answer newAnswer) throws UnauthorizedActionException, ResourceUnavailableException;

	void delete(Answer answer) throws UnauthorizedActionException, ResourceUnavailableException;

	List<Answer> findAnswersByQuestion(Question question);

	int countAnswersInQuestion(Question question);
}