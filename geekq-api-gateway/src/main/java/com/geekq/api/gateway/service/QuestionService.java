package com.geekq.api.gateway.service;

import java.util.List;

import com.geekq.api.gateway.exceptions.ResourceUnavailableException;
import com.geekq.api.gateway.exceptions.UnauthorizedActionException;
import com.geekq.api.gateway.model.Answer;
import com.geekq.api.gateway.model.Question;
import com.geekq.api.gateway.model.Quiz;

public interface QuestionService {
	Question save(Question question) throws UnauthorizedActionException;

	Question find(Long id) throws ResourceUnavailableException;

	List<Question> findQuestionsByQuiz(Quiz quiz);

	List<Question> findValidQuestionsByQuiz(Quiz quiz);

	Question update(Question question) throws ResourceUnavailableException, UnauthorizedActionException;

	void delete(Question question) throws ResourceUnavailableException, UnauthorizedActionException;

	Boolean checkIsCorrectAnswer(Question question, Long answer_id);

	void setCorrectAnswer(Question question, Answer answer);

	Answer getCorrectAnswer(Question question);

	Answer addAnswerToQuestion(Answer answer, Question question);

	int countQuestionsInQuiz(Quiz quiz);

	int countValidQuestionsInQuiz(Quiz quiz);
}