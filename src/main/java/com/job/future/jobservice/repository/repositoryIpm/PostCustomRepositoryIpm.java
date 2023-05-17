package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.PostContentDTO;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.repository.PostCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.job.future.jobservice.utils.ConstantSQL;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class PostCustomRepositoryIpm implements PostCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(PostContentDTO postContentDTO) {

        entityManager.persist(
                Post.builder()
                        .content(postContentDTO.getContent())
                        .title(postContentDTO.getTitle())
                        .createdAt(postContentDTO.getCreatedAt()));
    }

  @Override
  public List<PostContentDTO> findPostContentByName(String title) {



//      return entityManager.createQuery(ConstantSQL.FIND_POST_CONTENT_BY_TITLE, Post.class)
//              .setParameter("title", title)
//              .getResultList();
    return  null;


    return null;
  }
}
