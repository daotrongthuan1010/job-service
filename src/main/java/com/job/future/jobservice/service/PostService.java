package com.job.future.jobservice.service;

import com.job.future.jobservice.api.request.postcontent.PostPostContentApiRequest;
import com.job.future.jobservice.api.response.postcontent.GetPostContentByTitleResponse;
import com.job.future.jobservice.dto.postcontent.GetPostContentDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

/**
 * @author thuandao1010
 * @version 1.0
 * @since 2023-02-11
 */
public interface PostService {
    public String PARAM_NULL = "PARAM_IS_NULL";

    public String NORECORDFOUND = "NO_RECORD_FOUND";

    void saveOrUpdate(PostPostContentApiRequest request, Authentication authentication);

    List<GetPostContentDTO> findPostByTitle(String title);




}
