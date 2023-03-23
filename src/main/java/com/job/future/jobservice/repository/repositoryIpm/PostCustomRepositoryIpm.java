package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.FindPostDto;
import com.job.future.jobservice.repository.PostCustomRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
