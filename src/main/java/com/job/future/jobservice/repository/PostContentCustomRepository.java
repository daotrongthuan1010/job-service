package com.job.future.jobservice.repository;


import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;

import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface PostContentCustomRepository {

    void save(PostPostContentDTO postContentDTO);

    void update(PostPostContentDTO postContentDTO);

}
