package com.job.future.jobservice.service;

import com.job.future.jobservice.api.request.comment.GetCommentApiRequest;
import com.job.future.jobservice.api.request.comment.PostCommentApiRequest;
import org.springframework.stereotype.Service;


public interface CommentService {
    void save(PostCommentApiRequest request);


}
