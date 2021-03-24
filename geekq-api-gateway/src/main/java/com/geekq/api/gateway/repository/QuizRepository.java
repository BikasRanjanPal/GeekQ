package com.geekq.api.gateway.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.geekq.api.gateway.model.Quiz;
import com.geekq.api.gateway.model.User;

@Repository("QuizRepository")
public interface QuizRepository extends PagingAndSortingRepository<Quiz, Long> {

	Page<Quiz> findByIsPublishedTrue(Pageable pageable);

	Page<Quiz> findByCreatedBy(User user, Pageable pageable);

	@Query("select q from Quiz q where q.name like %?1%")
	Page<Quiz> searchByName(String name, Pageable pageable);

	Quiz findOne(Long id);
}
