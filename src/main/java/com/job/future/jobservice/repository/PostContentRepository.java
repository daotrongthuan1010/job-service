package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface PostContentRepository  extends JpaRepository<Post, Long> {


}
