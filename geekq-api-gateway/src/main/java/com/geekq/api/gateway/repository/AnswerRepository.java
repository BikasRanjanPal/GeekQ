package com.geekq.api.gateway.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.geekq.api.gateway.model.Answer;
import com.geekq.api.gateway.model.Question;

@Repository("AnswerRepository")
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	int countByQuestion(Question question);

	List<Answer> findByQuestionOrderByOrderAsc(Question question);

	Answer findOne(Long id);

}