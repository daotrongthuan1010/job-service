package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.model.Post;
<<<<<<< Updated upstream
import com.job.future.jobservice.repository.PostContentCustomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;
=======
import com.job.future.jobservice.repository.PostContentRepository;
import com.job.future.jobservice.repository.PostCustomRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
>>>>>>> Stashed changes

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */

@Repository
<<<<<<< Updated upstream
public class PostCustomRepositoryIpm implements PostContentCustomRepository {
=======
@RequiredArgsConstructor
public class PostCustomRepositoryIpm implements PostCustomRepository {
>>>>>>> Stashed changes

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger log = LogManager.getLogger(PostCustomRepositoryIpm.class);


    private final PostCustomRepository postCustomRepository;


    private final PostContentRepository postContentRepository;


    @Override
    @Transactional
    public void save(PostPostContentDTO postContentDTO) {

        Post post = Post.builder()
                .content(postContentDTO.getContent())
                .createdAt(postContentDTO.getCreateAt())
                .title(postContentDTO.getTitle())
                .build();

        entityManager.persist(post);

    }

    @Override
    @Transactional
    public void update(PostPostContentDTO postContentDTO) {

        try {
            Post post = Post.builder()
                    .content(postContentDTO.getContent())
                    .createdAt(postContentDTO.getCreateAt())
                    .title(postContentDTO.getTitle()).build();

            entityManager.persist(post);
        }
        catch (PessimisticLockException exception){
            log.error("Optimistic lock exception occurred: {}", exception.getMessage());
        }


    }


}
