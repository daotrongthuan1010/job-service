package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.FindPostDto;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.repository.PostCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class PostCustomRepositoryIpm implements PostCustomRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<FindPostDto> findPostByName(String name){


return null;

  }

}
