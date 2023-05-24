package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.repository.PostContentCustomRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
@Repository
public class PostCustomRepositoryIpm implements PostContentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public void save(PostPostContentDTO postContentDTO) {

        Post post = Post.builder()
                .content(postContentDTO.getContent())
                .createdAt(postContentDTO.getCreateAt())
                .title(postContentDTO.getTitle()).build();

        entityManager.persist(post);

    }
}
