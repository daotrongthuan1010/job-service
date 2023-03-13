package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.JobCategory;
import java.util.Optional;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public interface JobCategoryRepository extends JpaRepository<Long, JobCategory> {

  void save(JobCategory jobCategory);

  @Cacheable("jobCategoryCache")
  Optional<JobCategory> findById(Long idCategoryJob);
}
