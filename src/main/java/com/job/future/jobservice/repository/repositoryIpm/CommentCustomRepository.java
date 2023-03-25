package com.job.future.jobservice.repository.repositoryIpm;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@Repository
public class CommentCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;
}
