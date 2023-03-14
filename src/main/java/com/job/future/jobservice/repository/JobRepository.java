package com.job.future.jobservice.repository;

import com.job.future.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {


  void  deleteById(Long id);
}
