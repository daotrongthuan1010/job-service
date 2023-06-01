package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentRepository extends JpaRepository<Long, Comment> {
    @Query(value = "", nativeQuery = true)
    List<Map<String, Object>> findAllComment();

}
