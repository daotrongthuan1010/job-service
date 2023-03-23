package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.repository.JobCustomRepository;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class JobCustomRepositoryIpm implements JobCustomRepository {

  private EntityManager entityManager;


}
