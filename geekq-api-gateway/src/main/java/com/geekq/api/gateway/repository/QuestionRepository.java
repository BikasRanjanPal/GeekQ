package com.geekq.api.gateway.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geekq.api.gateway.model.Question;
import com.geekq.api.gateway.model.Quiz;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {
	int countByQuiz(Quiz quiz);

	int countByQuizAndIsValidTrue(Quiz quiz);

	List<Question> findByQuizOrderByOrderAsc(Quiz quiz);

	List<Question> findByQuizAndIsValidTrueOrderByOrderAsc(Quiz quiz);

	Question findOne(Long id);
}