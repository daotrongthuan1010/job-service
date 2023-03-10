package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.GetCommentByPostDto;
import com.job.future.jobservice.repository.CommentCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class CommentCustomRepositoryIpm implements CommentCustomRepository {

  private static final String sql = "";
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<GetCommentByPostDto> findAllCommentByPost() {

    List<GetCommentByPostDto> list =
        entityManager.createNativeQuery("", GetCommentByPostDto.class ).getResultList();
    return null;
  }
}
