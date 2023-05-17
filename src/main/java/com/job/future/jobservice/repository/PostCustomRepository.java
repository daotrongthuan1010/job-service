package com.job.future.jobservice.repository;


import com.job.future.jobservice.dto.PostContentDTO;

import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface PostCustomRepository {

    void save(PostContentDTO postContentDTO);

    List<PostContentDTO> findPostContentByName(String title);





}
