package com.job.future.jobservice.service;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.dto.postcontent.PostPostContentDTO;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface PostService {

    void save(PostPostContentApiRequest postContentDTO);

}
