package com.job.future.jobservice.repository;

import com.job.future.jobservice.dto.comment.CommentPostDTO;
import com.job.future.jobservice.model.Comment;

public interface CommentCustomRepository {

    void save(CommentPostDTO comment);

    void update(CommentPostDTO comment);
}
