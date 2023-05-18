package com.job.future.jobservice.repository;


import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;

import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface PostCustomRepository {

    void save(PostPostContentDTO postContentDTO);

    List<GetPostContentDTO> findPostContentByName(String title);





}
