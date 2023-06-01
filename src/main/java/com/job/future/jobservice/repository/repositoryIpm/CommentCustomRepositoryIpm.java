package com.job.future.jobservice.repository.repositoryIpm;

import com.job.future.jobservice.dto.comment.CommentPostDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;
import com.job.future.jobservice.model.Comment;
import com.job.future.jobservice.model.Post;
import com.job.future.jobservice.repository.CommentCustomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PessimisticLockException;
import java.time.LocalDateTime;

@Repository
public class CommentCustomRepositoryIpm implements CommentCustomRepository {
    private static final Logger log = LogManager.getLogger(CommentCustomRepositoryIpm.class);
    @PersistenceContext
    private EntityManager entityManager;
    LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    @Transactional
    public void save(CommentPostDTO comment) {


        Comment.builder().content(comment.getContent())
                .createdAt(localDateTime);
        entityManager.persist(comment);
    }

    @Override
    @Transactional
    public void update(CommentPostDTO comment) {

        try {
            Comment.builder().content(comment.getContent())
                    .createdAt(localDateTime);
            entityManager.persist(comment);
        } catch (PessimisticLockException exception) {
            log.error("Optimistic lock exception occurred: {}", exception.getMessage());
        }


    }
}
