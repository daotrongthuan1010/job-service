package com.job.future.jobservice.repository;

import com.job.future.jobservice.dto.GetCommentByPostDto;
import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface CommentCustomRepository {

  List<GetCommentByPostDto> findAllCommentByPost();


}
