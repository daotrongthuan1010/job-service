package com.job.future.jobservice.dto.comment;

import com.job.future.jobservice.model.CommentReaction;
import com.job.future.jobservice.model.Post;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class GetCommentDTO {

    private Long id;

    private String code;

    private String content;

    private Long views;

    private LocalDateTime createdUpdate;

    private String commentReactions;

    private Post post;
}
